package fpc.aoc.year2019.day18._private;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@EqualsAndHashCode(of = "idx")
public class Pos {

    @NonNull
    private final Maze maze;

    @Getter
    private final int idx;

    public boolean isWall() {
        return maze.isWall(this);
    }

    public boolean isKeyAndNotStartingPoint() {
        return maze.isKeyAndNotStartingPoint(this);
    }

    public boolean isDoor() {
        return maze.isDoor(this);
    }

    @NonNull
    public Optional<Key> getKey() {
        return maze.getKeyAt(this);
    }

    @NonNull
    public Optional<Door> getDoor() {
        return maze.getDoorAt(this);
    }

    public Pos up() {
        return maze.aboveOf(this);
    }

    public Pos down() {
        return maze.belowOf(this);
    }

    public Pos left() {
        return maze.leftTo(this);
    }

    public Pos right() {
        return maze.rightTo(this);
    }

    public boolean isNotAStartingPoint() {
        return maze.isNotAStartingPoint(this);
    }
}
