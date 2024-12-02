package fpc.aoc.year2019.day23._private.packet;

import lombok.NonNull;
import lombok.Value;

/**
 * @author Bastien Aracil
 **/
@Value
public class DataPacket implements Packet {

    String x;

    String y;

    @NonNull
    @Override
    public <T> T accept(PacketVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @NonNull
    public DataPacket withSource() {
        return new DataPacket(x,y);
    }

}
