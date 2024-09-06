package fpc.aoc.year2019.day4;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.Arrays;

public abstract class BaseDay4Solver extends SmartSolver<String> {


    @Override
    protected @NonNull Converter<String> getConverter() {
        return Converter.FIRST_LINE;
    }

    @Override
    protected @NonNull Object doSolve(@NonNull String input) {
        final var codes = Arrays.stream(input.split("-")).map(Code::create).toList();
        return solve(codes.get(0),codes.get(1));
    }


    protected abstract int solve(@NonNull Code first,@NonNull Code last);

}
