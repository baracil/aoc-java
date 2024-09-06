package fpc.aoc.year2019.day5;

import fpc.aoc.api.Solver;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.io.ProgramIO;
import lombok.NonNull;

public class Day5Part2Solver extends Day5Solver {

    public static Solver provider() {
        return new Day5Part2Solver();
    }


    @Override
    protected String doSolve(@NonNull Program program) {
        return program.launchAndWait("Day5 Part 2", ProgramIO.fromList("5").ignoreOutput()).getLastOutput();
    }

}
