package fpc.aoc.year2019.day11.computation;

import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Getter
public class RobotState {

    @NonNull
    public static RobotState initial() {
        return new RobotState(Direction.UP, Position.of(0, 0), new HashSet<>());
    }

    @NonNull
    private final Direction direction;

    @NonNull
    private final Position currentPosition;

    @NonNull
    private final Set<Position> visitedPosition;

    @NonNull
    public RobotState turnLeft() {
        return new RobotState(direction.turnLeft(),currentPosition,visitedPosition);
    }

    @NonNull
    public RobotState turnRight() {
        return new RobotState(direction.turnRight(),currentPosition,visitedPosition);
    }

    @NonNull
    public RobotState moveForward() {
        return new RobotState(direction, direction.moveForward(currentPosition),visitedPosition);
    }

    public RobotState setCurrentVisited() {
        visitedPosition.add(currentPosition);
        return this;
    }

    public int numberOfPaintedPanels() {
        return visitedPosition.size();
    }

    @Override
    public String toString() {
        return String.format("%3s,%3s  %s",currentPosition.x(),currentPosition.y(),direction);
    }
}
