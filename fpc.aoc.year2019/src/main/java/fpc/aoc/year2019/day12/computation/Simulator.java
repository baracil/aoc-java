package fpc.aoc.year2019.day12.computation;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;

@RequiredArgsConstructor
public class Simulator {

    @NonNull
    private final MoonSystem original;

    private int time;
    private State x;
    private State y;
    private State z;

    @Synchronized
    @NonNull
    public MoonSystem simulateToTime(int time) {
        if (x == null || this.time > time) {
            reset();
        }
        while (this.time < time) {
            simulateOneStep();
        }
        return buildSystem();
    }

    @NonNull
    private MoonSystem buildSystem() {
        return new MoonSystem(time, State.moons(x,y,z));
    }

    private void simulateOneStep() {
        time++;
        x = x.update();
        y = y.update();
        z = z.update();
    }

    private void reset() {
        this.time = 0;
        this.x = new State(original, Vector::x);
        this.y = new State(original, Vector::y);
        this.z = new State(original, Vector::z);
    }

}
