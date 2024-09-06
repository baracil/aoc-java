package fpc.aoc.year2019.day23._private;

import fpc.aoc.computer.Program;
import fpc.aoc.year2019.day23._private.packet.DataPacket;
import lombok.NonNull;

/**
 * @author perococco
 **/
public class NetworkWithNAT extends AbstractNetwork {


    public NetworkWithNAT(@NonNull Program program) {
        super(program);
    }

    public NetworkWithNAT(@NonNull Program program, int networkSize) {
        super(program,networkSize);
    }

    private DataPacket lastReceived = null;

    private DataPacket lastSent = null;

    private boolean resultAlreadySet = false;

    @Override
    protected void handlePort255(@NonNull DataPacket packet) {
        lastReceived = packet;
    }

    @Override
    protected void handleIdleNetwork() {
        if (lastReceived == null) {
            System.out.println("Something wrong");
            return;
        }

        if (isSameYInARow(lastReceived)) {
            setResult(lastReceived.y());
        }

        lastSent = lastReceived;
        sendToNetwork(new Message(255,0,lastSent));
    }

    private boolean isSameYInARow(DataPacket nextToSend) {
        return lastSent != null && lastSent.y().equals(nextToSend.y());
    }

    @Override
    protected void setResult(@NonNull String value) {
        if (resultAlreadySet) {
            return;
        }
        resultAlreadySet = true;
        super.setResult(value);
    }
}
