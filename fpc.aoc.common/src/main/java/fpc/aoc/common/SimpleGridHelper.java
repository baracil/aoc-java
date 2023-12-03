package fpc.aoc.common;

import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleGridHelper implements GridHelper {

    @Getter
    private final int width;
    @Getter
    private final int height;

    private final Position[] positions;

    public SimpleGridHelper(int width, int height) {
        this.width = width;
        this.height = height;
        this.positions = new Position[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                positions[x + y * width] = Position.of(x, y);
            }
        }
    }

    private Position at(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return positions[x + y * width];
        }
        throw new IllegalArgumentException();
    }

    @Override
    public @NonNull Stream<Position> allAdjacentPosition(@NonNull Position center) {
        final int xc = center.x();
        final int yc = center.y();
        return Stream.of(
                at(xc - 1, yc - 1),
                at(xc - 1, yc),
                at(xc - 1, yc + 1),
                at(xc + 1, yc - 1),
                at(xc + 1, yc),
                at(xc + 1, yc + 1),
                at(xc, yc - 1),
                at(xc, yc + 1)
        ).filter(Objects::nonNull);
    }

    @Override
    public @NonNull Stream<Position> positionsInDirection(@NonNull Position center, @NonNull Displacement displacement) {
        final int dx = displacement.dx();
        final int dy = displacement.dy();
        return IntStream.iterate(1, i -> i + 1)
                        .mapToObj(i -> at(center.x() + dx * i, center.y() + dy * i))
                        .takeWhile(Objects::nonNull);
    }

    public @NonNull Stream<Position> allPositionOnGrid() {
        return Arrays.stream(positions);
    }

    @Override
    public int linearIndexFor(@NonNull Position position) {
        return position.linearIndex(width);
    }

    @Override
    public @NonNull Position positionFor(int linearIndex) {
        return at(linearIndex%width , linearIndex/width);
    }
}
