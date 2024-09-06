package fpc.aoc.year2019.day10.computation;

import fpc.aoc.common.Tools;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AsteroidField {

    @NonNull
    private final List<Position> asteroidPositions;

    public AsteroidField(@NonNull SpaceMap<Type> spaceMap) {
        this.asteroidPositions = spaceMap.listPositionsMatching(Type.ASTEROID::equals);
    }

    @NonNull
    public Base findOptimalBase() {
        return this.asteroidPositions.stream()
                                     .map(this::createBase)
                                     .max(Base.COMPARE_ON_NB_VISIBLE)
                                     .orElseThrow();
    }

    @NonNull
    private Base createBase(@NonNull Position position) {
        return new Base(position,countVisibleAsteroid(position));
    }


    public int countVisibleAsteroid(@NonNull Position position) {
        return Tools.toInt(asteroidPositions.stream()
                                            .filter(position::notEqual)
                                            .map(p -> p.subtract(position))
                                            .distinct()
                                            .count()
        );
    }

    public VisibilityMap createVisibilityMapFrom(@NonNull Position position) {
        final Map<Direction,List<RadialRelativePosition>> positionByDirection;
        positionByDirection = asteroidPositions.stream ()
                                               .filter(p -> p.notEqual(position))
                                               .map(p -> p.positionRelativeTo(position))
                                               .collect(
                                                       Collectors.groupingBy(RadialRelativePosition::direction)
                                               );

        final List<Los> los = positionByDirection.entrySet()
                           .stream()
                           .map(Los::create)
                           .collect(Collectors.toList());

        return new VisibilityMap(position, los);
    }

}
