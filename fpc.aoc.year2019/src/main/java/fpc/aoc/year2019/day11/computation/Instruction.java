package fpc.aoc.year2019.day11.computation;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

@RequiredArgsConstructor
public enum Instruction {
    PAINT_WHITE((s,h) -> paint(s,h,Color.WHITE)),
    PAINT_BLACK((s,h) -> paint(s,h,Color.BLACK)),
    TURN_LEFT(RobotState::turnLeft),
    TURN_RIGHT(RobotState::turnRight),
    MOVE_FORWARD(RobotState::moveForward),
    READ_COLOR(r->r),
    HALT(r->r),
    ;

    private final BiFunction<RobotState,Hull,RobotState> execution;

    Instruction(Color color) {
        this((s,h) -> paint(s,h,color));
    }

    Instruction(UnaryOperator<RobotState> stateModifier) {
        this.execution = (r,h) -> stateModifier.apply(r);
    }

    @NonNull
    public RobotState execute(RobotState robotState, Hull hull) {
        return execution.apply(robotState,hull);
    }

    @NonNull
    private static RobotState paint(RobotState state,Hull hull, Color color) {
        hull.paint(state.currentPosition(),color);
        return state.setCurrentVisited();
    }

}
