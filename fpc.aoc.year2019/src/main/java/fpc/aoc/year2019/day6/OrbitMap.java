package fpc.aoc.year2019.day6;

import lombok.NonNull;

public interface OrbitMap {

    void depthFirstWalk(@NonNull OrbitWalker walker);

    @NonNull
    OrbitPath pathFromRoot(@NonNull String bodyId);

    int distanceFromRoot(@NonNull String bodyId);
}
