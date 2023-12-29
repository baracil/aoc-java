package fpc.aoc.year2020.day20;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day20.structures.ImageArray;
import fpc.aoc.year2020.day20.structures.ImageArrayBuilder;
import fpc.aoc.year2020.day20.structures.Parser;
import lombok.NonNull;

public abstract class Day20Solver extends SmartSolver<ImageArray> {

    @Override
    protected @NonNull Converter<ImageArray> getConverter() {
        return Converter.from(Parser::parse).andThen(ImageArrayBuilder::build);
    }

}
