package fpc.aoc.year2019.day3;

import lombok.*;

import java.util.Comparator;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Point {

    public static final Point CENTRAL_PORT = new Point(0, 0);

    public static Point create(int x, int y) {
        if (x == 0 && y == 0) {
            return CENTRAL_PORT;
        }
        return new Point(x,y);
    }

    public static final Comparator<Point> ON_CENTRAL_PORT_DISTANCE = Comparator.comparingInt(
            Point::distanceToCentralPort);

    int x;

    int y;

    @Getter int distanceToCentralPort;


    @NonNull
    public Point pointAbove() {
        return create(x,y+1);
    }

    @NonNull
    public Point pointBelow() {
        return create(x,y-1);
    }

    @NonNull
    public Point pointOnTheRight() {
        return create(x+1,y);
    }

    @NonNull
    public Point pointOnTheLeft() {
        return create(x-1,y);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.distanceToCentralPort = Math.abs(x)+Math.abs(y);
    }

    public boolean isNotCentralPort() {
        return this.x != 0 || this.y != 0;
    }
}
