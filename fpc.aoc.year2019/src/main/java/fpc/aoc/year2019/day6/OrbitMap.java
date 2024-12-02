package fpc.aoc.year2019.day6;

import lombok.NonNull;

public interface OrbitMap {

    void depthFirstWalk(OrbitWalker walker);

    @NonNull
    OrbitPath pathFromRoot(String bodyId);

    int distanceFromRoot(String bodyId);
}
