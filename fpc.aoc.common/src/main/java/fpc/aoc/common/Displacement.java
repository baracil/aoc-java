package fpc.aoc.common;

import lombok.Value;

@Value
public class Displacement {

    public static final Displacement N = Displacement.of(0, -1);
    public static final Displacement E = Displacement.of(1, 0);
    public static final Displacement S = Displacement.of(0, 1);
    public static final Displacement W = Displacement.of(-1, 0);
    public static final Displacement NE = Displacement.of(1, -1);
    public static final Displacement NW = Displacement.of(-1, -1);
    public static final Displacement SE = Displacement.of(1, 1);
    public static final Displacement SW = Displacement.of(-1, 1);


    int dx;

    int dy;

    public static Displacement of(int dx, int dy) {
        return new Displacement(dx,dy);
    }

}
