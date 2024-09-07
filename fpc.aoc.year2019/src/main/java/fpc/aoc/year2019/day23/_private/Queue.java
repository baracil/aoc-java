package fpc.aoc.year2019.day23._private;

import fpc.aoc.year2019.day23._private.packet.AddressPacket;
import fpc.aoc.year2019.day23._private.packet.DataPacket;
import fpc.aoc.year2019.day23._private.packet.Packet;
import fpc.aoc.year2019.day23._private.packet.PacketVisitor;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Bastien Aracil
 **/
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Queue {

    @NonNull
    public static Queue create(int networkAddress) {
        final Queue queue = new Queue(networkAddress);
        queue.write(AddressPacket.create(networkAddress));
        return queue;
    }

    private final int networkAddress;

    private final BlockingDeque<Packet> queue = new LinkedBlockingDeque<>();

    private final Visitor visitor = new Visitor();

    private String pendingData = null;

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @NonNull
    public Optional<String> read() throws InterruptedException {
        if (pendingData != null) {
            return Optional.of(handleWithPendingData());
        } else {
            return handleWithoutPendingData();
        }
    }

    public void write(@NonNull Packet packet) {
        queue.offerLast(packet);
    }


    @NonNull
    private String handleWithPendingData() {
        assert pendingData != null;
        final String y = pendingData;
        pendingData = null;
        queue.removeFirst();
        return y;
    }

    @NonNull
    private Optional<String> handleWithoutPendingData() throws InterruptedException {
        final Packet packet = queue.peekFirst();
        if (packet == null) {
            return Optional.empty();
        }
        final String result = packet.accept(visitor);
        if (pendingData == null) {
            queue.removeFirst();
        }
        return Optional.of(result);
    }

    private class Visitor implements PacketVisitor<String> {

        @NonNull
        @Override
        public String visit(@NonNull AddressPacket addressPacket) {
            pendingData = null;
            return String.valueOf(addressPacket.networkAddress());
        }

        @NonNull
        @Override
        public String visit(@NonNull DataPacket dataPacket) {
            pendingData = dataPacket.y();
            return dataPacket.x();
        }
    }

}
