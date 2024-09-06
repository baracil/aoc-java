package fpc.aoc.year2019.day12.computation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PeriodFinder {

    public static TimeOfDuplicates findPeriod(MoonSystem moonSystem, ToIntFunction<Vector> coordinateGetter) {
        return new PeriodFinder(new State(moonSystem, coordinateGetter)).find();
    }

    private final State initialSate;

    private TimeOfDuplicates find() {
        final Map<State,Integer> history = new HashMap<>();

        int time = 0;
        State current = initialSate;

        history.put(current, time);
        while (true) {
            current = current.update();
            time++;
            final Integer previous = history.put(current, time);
            if (previous!=null) {
                return new TimeOfDuplicates(previous, time);
            }
        }
    }

}
