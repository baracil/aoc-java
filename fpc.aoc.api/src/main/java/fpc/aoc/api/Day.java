package fpc.aoc.api;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Tools;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

@RequiredArgsConstructor
public enum Day {
    DAY_1(1),
    DAY_2(2),
    DAY_3(3),
    DAY_4(4),
    DAY_5(5),
    DAY_6(6),
    DAY_7(7),
    DAY_8(8),
    DAY_9(9),
    DAY_10(10),
    DAY_11(11),
    DAY_12(12),
    DAY_13(13),
    DAY_14(14),
    DAY_15(15),
    DAY_16(16),
    DAY_17(17),
    DAY_18(18),
    DAY_19(19),
    DAY_20(20),
    DAY_21(21),
    DAY_22(22),
    DAY_23(23),
    DAY_24(24),
    DAY_25(25),
    ;

    public static final Comparator<Day> DAY_COMPARATOR = Comparator.comparing(d -> d.numericalValue);

    private final int numericalValue;

    public @NonNull AOCProblemId createIdWith(@NonNull Part part) {
        return new AOCProblemId(this,part);
    }

    @NonNull
    public static Day parse(@NonNull String value) {
        final Predicate<Day> predicate = Tools.parseInteger(value)
                                              .map(Day::predicateOnNumericalValue)
                                              .orElseGet(() -> predicateOnName(value));
        return Arrays.stream(values())
                     .filter(predicate)
                     .findFirst()
                     .orElseThrow(() -> new AOCException("Could not convert '" + value + "' to a Day"));
    }

    @NonNull
    private static Predicate<Day> predicateOnNumericalValue(int numericalValue) {
        return day -> day.numericalValue == numericalValue;
    }

    @NonNull
    private static Predicate<Day> predicateOnName(@NonNull String name) {
        return day -> day.name().equalsIgnoreCase(name);
    }

    public String getInputFileName() {
        return String.format("input_day_%02d.txt",numericalValue);
    }
}
