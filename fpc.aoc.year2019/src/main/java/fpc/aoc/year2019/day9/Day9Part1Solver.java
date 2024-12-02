package fpc.aoc.year2019.day9;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;
import fpc.aoc.computer.ExecutionResult;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.computer.io.ProgramIO;

public class Day9Part1Solver extends ProgramBasedSolver {

    public static Solver provider() {
        return new Day9Part1Solver();
    }


    @Override
    protected String doSolve(Program program) {
        final ExecutionResult result = program.launch(id().toString(), ProgramIO.fromList("1").ignoreOutput()).waitTermination();

        if (result.numberOfOutput() != 1) {
            System.out.println("Opcode error :");
            result.forEachOutput(System.out::println);
            throw new AOCException("Invalid IntComputer");
        } else {
            return result.getLastOutput();
        }
    }
}
