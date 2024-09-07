package fpc.aoc.year2019.day23._private;

import fpc.aoc.common.AOCException;
import fpc.aoc.year2019.day23._private.packet.DataPacket;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * @author Bastien Aracil
 **/
@RequiredArgsConstructor
public class MessageConstructor {

    private final int sourceAddress;

    private int destinationAddress = -1;
    private String x;
    private String y;

    @NonNull
    public Optional<Message> pushValue(@NonNull String value) {
        final Message result;
        if (destinationAddress < 0) {
            destinationAddress = Integer.parseInt(value);
            result = null;
        }
        else if (x == null) {
            x = value;
            result = null;
        }
        else if (y == null) {
            y = value;
            result = new Message(sourceAddress,destinationAddress, new DataPacket(x, y));
        }
        else {
            throw new AOCException("Too many values");
        }
        if (result!=null) {
            reset();
        }
        return Optional.ofNullable(result);
    }

    public void reset() {
        destinationAddress = -1;
        x = null;
        y = null;
    }
}
