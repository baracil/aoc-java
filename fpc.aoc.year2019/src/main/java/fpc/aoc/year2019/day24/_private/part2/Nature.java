package fpc.aoc.year2019.day24._private.part2;

import fpc.aoc.year2019.day24._private.BugColony;
import fpc.aoc.year2019.day24._private.Position;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author perococco
 **/
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Nature {

    @NonNull
    public static BugColony evolve(@NonNull BugColony colony) {
        return new Nature(colony).evolve();
    }

    @NonNull
    private final BugColony current;

    private BugColony newColony;

    private final Map<Position,Integer> census = new HashMap<>();

    @NonNull
    private BugColony evolve() {
        performCensus();
        computeNewColony();
        return newColony;
    }

    private void performCensus() {
        census.clear();
        current.bugPositionsStream()
               .forEach(p -> p.forEachNeighbour(this::increaseCount));
    }

    private void increaseCount(@NonNull Position position) {
        census.merge(position, 1, Integer::sum);
    }

    private void computeNewColony() {
        newColony = census.keySet()
              .stream()
              .filter(this::isBugAliveAt)
              .collect(Collectors.collectingAndThen(Collectors.toUnmodifiableSet(),BugColony::new));
    }

    private boolean isBugAliveAt(@NonNull Position position) {
        final int numberOfNeighbours = census.getOrDefault(position,0);
      return switch (numberOfNeighbours) {
        case 1 -> true;
        case 2 -> !current.hasBugAt(position);
        default -> false;
      };
    }


}
