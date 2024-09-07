package fpc.aoc.year2019.day23._private;

import fpc.aoc.year2019.day23._private.packet.DataPacket;
import lombok.NonNull;
import lombok.Value;
/**
 * @author Bastien Aracil
 **/
@Value
public class Message {

    int sourceAddress;

    int destinationAddress;

    @NonNull DataPacket packet;

    @Override
    public String toString() {
        return String.format("Message{ %2d -> %2d : %s}",sourceAddress,destinationAddress,packet);
    }

    public String x() {
        return packet.x();
    }

    public String y() {
        return packet.y();
    }
}
