package fpc.aoc.year2019.day23._private;

import fpc.aoc.computer.Program;
import fpc.aoc.year2019.day23._private.packet.DataPacket;
import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public class FirstYNetwork extends AbstractNetwork {

    public FirstYNetwork(@NonNull Program program, int networkSize) {
        super(program,networkSize);
    }

    public FirstYNetwork(@NonNull Program program) {
        super(program);
    }

    @Override
    protected void handlePort255(@NonNull DataPacket packet) {
        setResult(packet.y());
    }

    @Override
    protected void handleIdleNetwork() {}
}
