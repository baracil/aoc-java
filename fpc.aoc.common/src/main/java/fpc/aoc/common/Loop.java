package fpc.aoc.common;

import lombok.Synchronized;

import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Loop {

    private Thread runnerThread = null;

    private Runner runner = null;


    @Synchronized
    public void stop() {
        if (runner != null) {
            try {
                runnerThread.interrupt();
                runner.waitForCompletion();
            } finally {
                runnerThread = null;
                runner = null;
            }
        }
    }

    @Synchronized
    public void interrupt() {
        if (runnerThread != null) {
            runnerThread.interrupt();
        }
    }

    public void waitUntilDone() {
        Optional.ofNullable(runner).ifPresent(Runner::waitForCompletion);
    }

    @Synchronized
    public boolean isRunning() {
        return runner!=null;
    }

    @Synchronized
    public void start() {
        stop();
        if (runner == null) {
            beforeStarting();
            runner = new Runner();
            runnerThread = new Thread(runner,getClass().getSimpleName());
            runnerThread.start();
        }
    }

    private class Runner implements Runnable {

        private final Lock lock = new ReentrantLock();
        private final Condition termination = lock.newCondition();
        private boolean done = false;

        @Override
        public void run() {
            try {
                initializeRun();
                iterate();
            } finally {
                beforeStopping();
                signalTermination();
                afterStopping();
            }
        }


        private void signalTermination() {
            lock.lock();
            try {
                done = true;
                termination.signalAll();
            } finally {
                lock.unlock();
            }
        }


        public void iterate() {
            while (!Thread.currentThread().isInterrupted()) {
                final boolean lastIteration;
                try {
                    lastIteration = performOneIteration();
                    if (lastIteration) {
                        break;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        public void waitForCompletion() {
            lock.lock();
            boolean interrupted = false;
            try {
                while (!done) {
                    try {
                        termination.await();
                    } catch (InterruptedException e) {
                        interrupted = true;
                    }
                }
            } finally {
                lock.unlock();
            }
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

    protected void beforeStarting() {};
    protected void initializeRun() {};
    protected abstract boolean performOneIteration() throws InterruptedException;
    protected void beforeStopping() {};
    protected void afterStopping() {};

}
