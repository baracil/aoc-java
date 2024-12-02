package fpc.aoc.year2019.day8;

import fpc.aoc.api.Solver;

import java.util.Comparator;
import java.util.List;

public class Day8Part1Solver extends Day8Solver {


    public static Solver provider() {
        return new Day8Part1Solver();
    }


    @Override
    protected Integer solve(List<Layer> layers) {
        return layers.stream()
                     .min(Comparator.comparingInt(Layer::numberOfZeroDigit))
                     .map(this::computeProductOfNumberOf1And2Digits)
                     .orElseThrow();
    }

    private int computeProductOfNumberOf1And2Digits(Layer layer) {
        return layer.numberOf(Pixel.D1_WHITE) * layer.numberOf(Pixel.D2_TRANSPARENT);
    }
}
