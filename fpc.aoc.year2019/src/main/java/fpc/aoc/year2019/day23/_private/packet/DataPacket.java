package fpc.aoc.year2019.day23._private.packet;

import lombok.NonNull;
import lombok.Value;

/**
 * @author Bastien Aracil
 **/
@Value
public class DataPacket implements Packet {

    @NonNull String x;

    @NonNull String y;

    @NonNull
    @Override
    public <T> T accept(@NonNull PacketVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @NonNull
    public DataPacket withSource() {
        return new DataPacket(x,y);
    }

}
