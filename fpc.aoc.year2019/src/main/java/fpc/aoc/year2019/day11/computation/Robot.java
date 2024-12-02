package fpc.aoc.year2019.day11.computation;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Logger;
import fpc.aoc.common.Loop;
import fpc.aoc.computer.Program;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Robot {

    public static Robot create(Program brainProgram) {
        return new Robot(new RobotBrain(brainProgram));
    }

    @NonNull
    private final RobotBrain brain;

    @Getter
    private RobotState state = RobotState.initial();

    private Hull hull = null;

    private final Loop loop = new RobotLoop();

    public void switchOn() {
        loop.start();
    }

    public void waitUntilDone() {
        loop.waitUntilDone();
    }

    public void placeOnHull(Hull hull) {
        this.hull = hull;
    }

    public int numberOfPaintedPanels() {
        return state.numberOfPaintedPanels();
    }


    private class RobotLoop extends Loop {

        private Hull hull;

        @Override
        protected void beforeStarting() {
            super.beforeStarting();
            Logger.get().log("Starting Robot");
            this.hull = Robot.this.hull;
            if (this.hull == null) {
                throw new AOCException("Robot is not on the hull");
            }
            state = RobotState.initial();
            brain.start();
        }

        @Override
        protected boolean performOneIteration() {
            final Instruction instruction = brain.takeInstruction();
            state = instruction.execute(state,hull);

            if (instruction == Instruction.READ_COLOR) {
                final Color color = hull.getPanelColor(state.currentPosition());
                brain.onColorRead(color);
            }

            return instruction == Instruction.HALT;
        }
    }

}
