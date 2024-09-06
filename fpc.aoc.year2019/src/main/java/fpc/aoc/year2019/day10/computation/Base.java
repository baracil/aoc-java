package fpc.aoc.year2019.day10.computation;

import lombok.NonNull;
import lombok.Value;

import java.util.Comparator;

@Value
public class Base {

    public static final Comparator<Base> COMPARE_ON_NB_VISIBLE = Comparator.comparingInt(Base::numberOfVisibleAsteroids);

    @NonNull Position position;

    int numberOfVisibleAsteroids;
}
