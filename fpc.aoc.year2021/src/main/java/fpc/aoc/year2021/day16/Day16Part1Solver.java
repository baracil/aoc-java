package fpc.aoc.year2021.day16;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day16.struct.Packet;
import lombok.NonNull;

public class Day16Part1Solver extends Day16Solver {

    public static @NonNull Solver provider() {
        return new Day16Part1Solver();
    }

    @Override
    public @NonNull Long doSolve(@NonNull Packet packet) {
        return packet.sumOfVersions();
    }

}
