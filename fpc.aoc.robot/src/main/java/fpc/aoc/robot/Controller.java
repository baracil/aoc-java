package fpc.aoc.robot;

import lombok.NonNull;

public interface Controller<O,S> {

    @NonNull
    Order<O> evaluateNextOrders(@NonNull S currentState);

    void updateOnReply(@NonNull String reply,@NonNull S previousState,@NonNull S currentState);

    default void controlStarting() {}

    default void controlStopping() {}

    default void controlStopped() {}
}
