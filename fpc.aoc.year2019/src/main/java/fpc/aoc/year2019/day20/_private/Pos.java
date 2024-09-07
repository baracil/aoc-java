package fpc.aoc.year2019.day20._private;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Bastien Aracil
 **/
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"index","level"})
public class Pos {

    @NonNull
    private final Maze maze;

    @Getter
    private final int level;

    @Getter
    private final int index;

    public Pos up() {
        return maze.positionAbove(this);
    }
    public Pos down() {
        return maze.positionBelow(this);
    }
    public Pos left() {
        return maze.positionLeftOf(this);
    }
    public Pos right() {
        return maze.positionRightOf(this);
    }

    public boolean isWall() {
        return maze.isWall(this);
    }
}
