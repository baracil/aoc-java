package fpc.aoc.year2019.day24._private.part1;

import lombok.NonNull;

import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Bastien Aracil
 **/
public class OtherHalfPositions implements UnaryOperator<int[]> {

    private static final OtherHalfPositions INSTANCE = new OtherHalfPositions();

    @NonNull
    public static int[] with(int[] position) {
        return INSTANCE.apply(position);
    }

    @Override
    @NonNull
    public int[] apply(int[] positions) {
        final Set<Integer> pos = IntStream.of(positions).boxed().collect(Collectors.toSet());
        return IntStream.range(0,25).filter(i -> !pos.contains(i)).toArray();
    }
}
