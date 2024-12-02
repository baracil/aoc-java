package fpc.aoc.year2019.day12.computation;

import fpc.aoc.common.AOCException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Vector {

    public static final Vector NIL = of(0, 0, 0);

    private static final Pattern VECTOR = Pattern.compile("<x=(-?\\d+), *y=(-?\\d+), *z=(-?\\d+)>");

    @NonNull
    public static Vector parse(String value) {
        final Matcher matcher = VECTOR.matcher(value);
        if (!matcher.matches()) {
            throw new AOCException("Could not parse the vector : " + value);
        }
        return Vector.of(
                Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2)),
                Integer.parseInt(matcher.group(3))
        );
    }

    public int energy() {
        return Math.abs(x)+Math.abs(y)+Math.abs(z);
    }

    public static Vector of(int x, int y, int z) {
        return new Vector(x,y,z);
    }

    private final int x;

    private final int y;

    private final int z;

    @NonNull
    public Vector add(Vector other) {
        return of(x+other.x,y+other.y,
                  z+other.z);
    }

    @NonNull
    public Vector forceBetween(Vector vector) {
        return Vector.of(
                Integer.signum(vector.x - x),
                Integer.signum(vector.y - y),
                Integer.signum(vector.z - z)
        );
    }

    @Override
    public String toString() {
        return String.format("x=%+3d, y=%+3d, z=%+3d",x,y,z);
    }
}
