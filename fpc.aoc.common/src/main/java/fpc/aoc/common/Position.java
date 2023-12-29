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

    public @NonNull Position displaced(@NonNull Translation translation) {
        return translate(translation.dx(), translation.dy());
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

    public int manhattanDistanceTo(Position beacon) {
        return Math.abs(this.x - beacon.x) + Math.abs(this.y - beacon.y);
    }

    public static @NonNull Position parseCommaSeparated(@NonNull String value) {
        final var idx = value.indexOf(",");
        return Position.of(Integer.parseInt(value.substring(0,idx)),Integer.parseInt(value.substring(idx+1)));
    }


}
