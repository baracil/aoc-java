package fpc.aoc.robot;

import lombok.NonNull;

public interface Controller<O,S> {

    @NonNull
    Order<O> evaluateNextOrders(S currentState);

    void updateOnReply(String reply,S previousState,S currentState);

    default void controlStarting() {}

    default void controlStopping() {}

    default void controlStopped() {}
}
