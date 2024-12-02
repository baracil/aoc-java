package fpc.aoc.year2019.day6;

import lombok.Getter;

public class OrbitCounter implements OrbitWalker {

    private int depth = -1;

    @Getter
    private int direct = 0;

    @Getter
    private int indirect = 0;

    @Override
    public void enter(Body body) {
        depth++;
        if (depth > 0) {
            direct+=1;
            indirect+=depth-1;
        }
    }

    @Override
    public void leave(Body body) {
        depth--;
    }

    public int sumOfDirectAndIndirectOrbits() {
        return direct+indirect;
    }

}
