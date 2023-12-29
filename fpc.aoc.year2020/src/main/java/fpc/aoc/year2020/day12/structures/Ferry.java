package fpc.aoc.year2020.day12.structures;

import fpc.aoc.common.Orientation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ferry {

    private @NonNull Orientation orientation;
    private int x;
    private int y;

//    public @NonNull Ferry x(int x) {
//        this.x = x;
//        return this;
//    }
//
//    public @NonNull Ferry y(int y) {
//        this.y = y;
//        return this;
//    }
//
//    public @NonNull Ferry increaseX(int quantity) {
//        this.x += quantity;
//        return this;
//    }
//
//    public @NonNull Ferry decreaseX(int quantity) {
//        return increaseX(-quantity);
//    }
//
//    public @NonNull Ferry increaseY(int quantity) {
//        this.y += quantity;
//        return this;
//    }
//
//    public @NonNull Ferry decreaseY(int quantity) {
//        return increaseY(-quantity);
//    }
//
//    public @NonNull Ferry turnLeft(int angle) {
//        return turnRight(-angle);
//    }
//
//    public @NonNull Ferry turnRight(int angle) {
//        this.orientation = this.orientation.turn(angle);
//        return this;
//    }
//
//    public @NonNull Ferry moveForward(int quantity) {
//        return switch (orientation) {
//            case E -> increaseX(quantity);
//            case W -> decreaseX(quantity);
//            case N -> increaseY(quantity);
//            case S -> decreaseY(quantity);
//        };
//    }
//
//    public void displace(@NonNull Movement movement) {
//        final Operation operation = movement.operation();
//        final int quantity = movement.quantity();
//        operation.apply(this,quantity);
//    }
//
    public int manhattanDistance() {
        return Math.abs(x)+Math.abs(y);
    }

    @Override
    public String toString() {
        return "Ferry{" +
                 orientation +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public void moveBy(int dx, int dy) {
        this.x+=dx;
        this.y+=dy;
    }
}
