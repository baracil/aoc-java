package fpc.aoc.year2019.day24._private;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.function.Consumer;

/**
 *
 *      |     |     |     |
 *  0 0 | 1 0 | 2 0 | 3 0 | 4 0
 *      |     |     |     |
 * -----+-----+-----+-----+-----
 *      |     |     |     |
 *  0 1 | 1 1 | 2 1 | 3 1 | 4 1
 *      |     |     |     |
 * -----+-----+-----+-----+-----
 *      |     |     |     |
 *  0 2 | 1 2 |  ?  | 3 2 | 4 2
 *      |     |     |     |
 * -----+-----+-----+-----+-----
 *      |     |     |     |
 *  0 3 | 1 3 | 2 3 | 3 3 | 4 3
 *      |     |     |     |
 * -----+-----+-----+-----+-----
 *      |     |     |     |
 *  0 4 | 1 4 | 2 4 | 3 4 | 4 4
 *      |     |     |     |
 * -----+-----+-----+-----+-----
 *
 * 7, 6, 6, 10, 10, 5, 15, 12 , 7, 9, 12
 *
 * @author perococco
 **/
@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Position {

    @NonNull
    public static Position create(int level, int x, int y) {
        return new Position(level,x,y);
    }

    int level;

    int x;

    int y;

    public void forEachNeighbour(@NonNull Consumer<Position> consumer) {
        forEachOnTheLeft(consumer);
        forEachOnTheRight(consumer);
        forEachAbove(consumer);
        forEachBelow(consumer);
    }


    private void forEachOnTheLeft(@NonNull Consumer<Position> consumer) {
        if (x==0) {
            consumer.accept(create(level-1,1,2));
        } else if (x == 3 && y == 2) {
            for (int y = 0; y < 5; y++) {
                consumer.accept(create(level+1,4,y));
            }
        } else {
            consumer.accept(create(level,x-1,y));
        }
    }


    private void forEachOnTheRight(@NonNull Consumer<Position> consumer) {
        if (x==4) {
            consumer.accept(create(level-1,3,2));
        } else if (x == 1 && y == 2) {
            for (int y = 0; y < 5; y++) {
                consumer.accept(create(level+1,0,y));
            }
        } else {
            consumer.accept(create(level,x+1,y));
        }
    }

    private void forEachBelow(@NonNull Consumer<Position> consumer) {
        if (y == 4) {
            consumer.accept(create(level-1,2,3));
        } else if (x == 2 && y == 1) {
            for (int x = 0; x < 5; x++) {
                consumer.accept(create(level+1,x,0));
            }
        } else {
            consumer.accept(create(level,x,y+1));
        }
    }
    private void forEachAbove(@NonNull Consumer<Position> consumer) {
        if (y == 0) {
            consumer.accept(create(level-1,2,1));
        } else if (x == 2 && y == 3) {
            for (int x = 0; x < 5; x++) {
                consumer.accept(create(level+1,x,4));
            }
        } else {
            consumer.accept(create(level,x,y-1));
        }
    }
}
