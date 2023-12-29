package fpc.aoc.year2021.day15.struct;

import lombok.NonNull;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PathFinder {


    public long findLowestRisk(@NonNull Map map) {
        final Deque<Path> toVisit = new ArrayDeque<>();
        final long[] lowestSoFar = new long[map.nbElements()];

        Arrays.fill(lowestSoFar,Long.MAX_VALUE);

        toVisit.addLast(new Path(map.startPosition(),0));

        while (!toVisit.isEmpty()) {
            final var path = toVisit.removeFirst();
            if (lowestSoFar[path.position]< path.risk) {
                continue;
            }

            lowestSoFar[path.position] = path.risk;

            map.neighbors(path.position).forEach(pos -> {
                final var newRisk = path.risk + map.riskAt(pos);
                if (newRisk<lowestSoFar[pos] && newRisk<lowestSoFar[map.endPosition()]) {
                    lowestSoFar[pos] = newRisk;
                    toVisit.addLast(new Path(pos,newRisk));
                }
            });

        }

        return lowestSoFar[map.endPosition()];

    }

    private static record Path(int position, long risk) {}
}
