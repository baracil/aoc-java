package fpc.aoc.robot._private;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Loop;
import fpc.aoc.computer.Execution;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.io.ProgramIO;
import fpc.aoc.computer.io.ProgramInput;
import fpc.aoc.computer.io.ProgramOutput;
import fpc.aoc.robot.Controller;
import fpc.aoc.robot.Order;
import fpc.aoc.robot.Robot;
import fpc.aoc.robot.StateUpdater;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;

import java.util.Optional;

@RequiredArgsConstructor
public class PrivateRobot<O, S> implements Robot<S> {

    @NonNull
    private final Program program;

    @NonNull
    private final StateUpdater<O,S> stateUpdater;

    @NonNull
    private final Controller<O,S> controller;


    private final DroidLoop loop = new DroidLoop();

    @Override
    @Synchronized
    public void switchOn() {
        loop.start();
    }

    @Override
    @Synchronized
    public void shutdown() {
        loop.stop();
    }

    @Override
    public void waitForShutdown() {
        loop.waitUntilDone();
    }


    @NonNull
    @Override
    public S getState() {
        return Optional.ofNullable(loop.state)
                       .orElseThrow(() -> new AOCException("Robot state not initialize"));
    }

    private class DroidLoop extends Loop {

        private Execution<ProgramInput<String>, ProgramOutput<String>> execution;

        private ProgramOutput<String> programOutput;

        private ProgramInput<String> programInput;

        private S state;

        @Override
        protected void beforeStarting() {
            super.beforeStarting();
            state = stateUpdater.createInitialState();
        }

        @Override
        protected void initializeRun() {
            super.initializeRun();
            controller.controlStarting();
            execution = program.launch("Robot", ProgramIO.duplex());
            programOutput = execution.programOutputAccessor();
            programInput = execution.programInputAccessor();
            execution.whenDone(this::interrupt);
        }

        @Override
        public void stop() {
            super.stop();
            Optional.ofNullable(execution).ifPresent(Execution::interrupt);
        }

        @Override
        protected boolean performOneIteration() throws InterruptedException {
            final Order<O> order = controller.evaluateNextOrders(state);
            if (order.stopRobot()) {
                return true;
            }

            order.dataToSend().forEach(programInput::write);

            final String reply = programOutput.read();
            final S currentState = this.state;
            state = stateUpdater.updateStateOnReply(state, order, reply);
            controller.updateOnReply(reply, currentState, state);

            return false;
        }

        @Override
        protected void beforeStopping() {
            super.beforeStopping();
            controller.controlStopping();
        }

        @Override
        protected void afterStopping() {
            super.afterStopping();
            controller.controlStopped();
        }
    }

}
