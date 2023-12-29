package fpc.aoc.year2020.day24.structures;

import lombok.AllArgsConstructor;
import lombok.NonNull;


@AllArgsConstructor
public class MutableHexaPoint {

    private int x;
    private int y;

    public @NonNull HexaPoint toImmutable() {
        return new HexaPoint(x,y);
    }

    public @NonNull void move(@NonNull Direction direction) {
        switch (direction) {
            case E -> x = x + 2;
            case NE -> {
                x++;
                y++;
            }
            case NW -> {
                x--;
                y++;
            }
            case W -> x = x - 2;
            case SW -> {
                x--;
                y--;
            }
            case SE -> {
                x++;
                y--;
            }
        }
        ;
    }
}
