package fpc.aoc.year2020.day8;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day8.structures.Instruction;
import fpc.aoc.year2020.day8.structures.Program;
import lombok.NonNull;

public abstract class Day8Solver extends SmartSolver<Program> {

    @Override
    protected @NonNull Converter<Program> getConverter() {
        return Converter.forItem(Instruction::parse).andThen(Program::new);
    }
}
