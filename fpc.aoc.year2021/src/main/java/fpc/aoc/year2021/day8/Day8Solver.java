package fpc.aoc.year2021.day8;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day8.struct.WiringInfo;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day8Solver extends SmartSolver<Stream<WiringInfo<String>>> {

    @Override
    protected @NonNull Converter<Stream<WiringInfo<String>>> getConverter() {
        return s -> s.stream().map(WiringInfo::parse);
    }
}
