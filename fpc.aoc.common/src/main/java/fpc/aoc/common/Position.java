package fpc.aoc.common;

import lombok.NonNull;
import lombok.Value;

@Value
public class Position {

    int x;

    int y;

    public static @NonNull Position of(int x, int y) {
        return new Position(x,y);
    }

    public @NonNull Position displaced(@NonNull Displacement displacement) {
        return translate(displacement.dx(), displacement.dy());
    }

    public @NonNull Position translate(int dx, int dy) {
        return of(x + dx, y + dy);
    }

    public @NonNull Position wrap(int width, int height) {
        final int nx = Tools.mod(x,width);
        final int ny = Tools.mod(y,height);
        if (nx == x && ny == y) {
            return this;
        }
        return of(nx,ny);
    }

    public int linearIndex(int lineStride) {
        return x+y*lineStride;
    }

    @Override
    public String toString() {
        return "(x=" + x + ", y=" + y + ")";
    }
}
