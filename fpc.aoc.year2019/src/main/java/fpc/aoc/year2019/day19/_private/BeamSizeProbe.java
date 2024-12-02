package fpc.aoc.year2019.day19._private;

import fpc.aoc.common.Position;
import fpc.aoc.common.Printer;
import fpc.aoc.computer.Program;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Bastien Aracil
 **/
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BeamSizeProbe {

    public static int probe(Program program) {
        return new BeamSizeProbe(program).probe();
    }

    @NonNull
    private final Program program;

    private int count = 0;

    private final Printer printer = new Printer(p -> "#",".");

    public int probe() {
        var position = Position.of(0, 0);
        while (position.y() < 50) {
            final BeamSlice slice = probeSlice(position);

            count+=slice.lengthBelow(50);
            position = slice.start().down();

        }

        return count;
    }

    public BeamSlice probeSlice(Position start) {
        return BeamSliceProbe.probe(program,start);
    }


}
