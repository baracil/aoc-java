package fpc.aoc.year2019.day4;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.Arrays;

public abstract class BaseDay4Solver extends SmartSolver<String> {


    @Override
    protected Converter<String> getConverter() {
        return Converter.FIRST_LINE;
    }

    @Override
    protected Object doSolve(String input) {
        final var codes = Arrays.stream(input.split("-")).map(Code::create).toList();
        return solve(codes.get(0),codes.get(1));
    }


    protected abstract int solve(Code first,Code last);

}
