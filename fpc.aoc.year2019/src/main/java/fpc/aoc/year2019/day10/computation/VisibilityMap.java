package fpc.aoc.year2019.day10.computation;

import fpc.aoc.common.Lazy;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class VisibilityMap {

    @NonNull
    private final Position reference;

    @NonNull
    private final List<Los> lineOfSights;

    private final Lazy<List<Position>> destructionOrder = new Lazy<>(this::computeDestructionOrder);


    public VisibilityMap(Position reference, List<Los> lineOfSights) {
        this.reference = reference;
        this.lineOfSights = lineOfSights.stream().sorted(Los.COMPARE_DIRECTION).toList();
    }

    @NonNull
    public List<Position> destructionOrder() {
        return destructionOrder.get();
    }

    @NonNull
    private List<Position> computeDestructionOrder() {
        final var positions = new ArrayList<Position>();

        final int nbAsteroids = lineOfSights.stream().mapToInt(Los::numberOfAsteroid).sum();
        final int nbLineOfSights = lineOfSights.size();

        final int[] indexes = new int[nbLineOfSights];
        int nbDestroyedAsteroid = 0;
        while (nbDestroyedAsteroid < nbAsteroids){
            for (int losIndex = 0; losIndex < nbLineOfSights; losIndex++) {
                final Los los = lineOfSights.get(losIndex);
                final int asteroidIndexInLos = indexes[losIndex];
                if (asteroidIndexInLos < los.numberOfAsteroid()) {
                    positions.add(los.getAsteroid(asteroidIndexInLos).add(reference));
                    indexes[losIndex]+=1;
                    nbDestroyedAsteroid++;
                }
            }
        }

        return positions;
    }
}
