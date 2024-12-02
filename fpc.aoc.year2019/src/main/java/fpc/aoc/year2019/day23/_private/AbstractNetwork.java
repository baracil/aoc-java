package fpc.aoc.year2019.day23._private;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.MutableSynchronizedValue;
import fpc.aoc.computer.Execution;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.io.NoAccessProgramIO;
import fpc.aoc.year2019.day23._private.packet.DataPacket;
import lombok.NonNull;
import lombok.Synchronized;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author Bastien Aracil
 **/
public abstract class AbstractNetwork implements Network {

    private final int networkSize;

    private final Queue[] queues;

    private final Execution<?,?>[] executions;
    private final boolean[] idle;

    private final MutableSynchronizedValue<String> result = new MutableSynchronizedValue<>("");


    public AbstractNetwork(Program program) {
        this(program, 50);
    }

    public AbstractNetwork(Program program, int networkSize) {
        this.networkSize = networkSize;
        this.idle = new boolean[networkSize];
        this.queues = IntStream.range(0,networkSize)
                               .mapToObj(Queue::create)
                               .toArray(Queue[]::new);

        this.executions = IntStream.range(0,networkSize)
                                   .mapToObj(addr -> program.launch("Computer "+addr,new NetworkIO(addr)))
                                   .toArray(Execution[]::new);
    }

    @NonNull
    @Override
    public String waitForResult()  {
        try {
            return result.waitForValueMatching(p -> !p.isEmpty());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AOCException("Wait interrupted");
        }
    }

    protected void setResult(String value) {
        this.result.setValue(value);
        shutdown();
    }

    protected void shutdown() {
        Arrays.stream(executions).forEach(Execution::interrupt);
        if (result.value().isEmpty()) {
            result.onError("Network Stopped");
        }
    }

    @Synchronized
    protected void sendToNetwork(Message message) {
        final int destinationAddress = message.destinationAddress();
        if (destinationAddress == 255) {
            handlePort255(message.packet());
        }
        else {
            queues[destinationAddress].write(message.packet());
        }
    }

    @NonNull
    @Synchronized
    protected Optional<String> readFromNetwork(int networkAddress) {
        try {
            final Optional<String> result = queues[networkAddress].read();
            idle[networkAddress] = result.isEmpty();
            checkIdleNetwork();
            return result;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AOCException("Read interrupted");
        }
    }

    protected void checkIdleNetwork() {
        final boolean networkIdle = IntStream.range(0,networkSize).allMatch(i -> idle[i]&&queues[i].isEmpty());
        if (networkIdle) {
            handleIdleNetwork();
        }
    }

    protected abstract void handleIdleNetwork();

    protected abstract void handlePort255(DataPacket packet);

    /**
     * @author Bastien Aracil
     **/
    public class NetworkIO extends NoAccessProgramIO {

        private final int networkAddress;

        private final MessageConstructor messageConstructor;

        public NetworkIO(int networkAddress) {
            this.networkAddress = networkAddress;
            this.messageConstructor = new MessageConstructor(networkAddress);
        }

        @Override
        public String read() {
            return readFromNetwork(networkAddress).orElse("-1");
        }

        @Override
        public void write(String value) {
            messageConstructor.pushValue(value).ifPresent(AbstractNetwork.this::sendToNetwork);
        }
    }
}
