package fpc.aoc.robot;

import fpc.aoc.computer.Program;
import fpc.aoc.robot._private.PrivateRobot;
import lombok.NonNull;

public interface Robot<S> {

    @NonNull
    static <O,S> Robot<S> create(@NonNull Program program, @NonNull StateUpdater<O,S> state, @NonNull Controller<O,S> controller) {
        return new PrivateRobot<>(program, state, controller);
    }

    void switchOn();

    void shutdown();

    void waitForShutdown();

    @NonNull
    S getState();

}
