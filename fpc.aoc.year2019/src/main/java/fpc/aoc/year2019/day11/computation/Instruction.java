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

    Instruction(@NonNull Color color) {
        this((s,h) -> paint(s,h,color));
    }

    Instruction(@NonNull UnaryOperator<RobotState> stateModifier) {
        this.execution = (r,h) -> stateModifier.apply(r);
    }

    @NonNull
    public RobotState execute(@NonNull RobotState robotState, @NonNull Hull hull) {
        return execution.apply(robotState,hull);
    }

    @NonNull
    private static RobotState paint(@NonNull RobotState state,@NonNull Hull hull, @NonNull Color color) {
        hull.paint(state.currentPosition(),color);
        return state.setCurrentVisited();
    }

}
