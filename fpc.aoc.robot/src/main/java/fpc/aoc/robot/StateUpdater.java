package fpc.aoc.robot;

import lombok.NonNull;

public interface StateUpdater<O,S> {

    @NonNull
    S createInitialState();

    @NonNull
    S updateStateOnReply(S current, Order<O> lastSendOrder, String reply);
}
