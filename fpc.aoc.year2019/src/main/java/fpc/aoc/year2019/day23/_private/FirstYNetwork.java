package fpc.aoc.year2019.day23._private;

import fpc.aoc.computer.Program;
import fpc.aoc.year2019.day23._private.packet.DataPacket;

/**
 * @author Bastien Aracil
 **/
public class FirstYNetwork extends AbstractNetwork {

    public FirstYNetwork(Program program, int networkSize) {
        super(program,networkSize);
    }

    public FirstYNetwork(Program program) {
        super(program);
    }

    @Override
    protected void handlePort255(DataPacket packet) {
        setResult(packet.y());
    }

    @Override
    protected void handleIdleNetwork() {}
}
