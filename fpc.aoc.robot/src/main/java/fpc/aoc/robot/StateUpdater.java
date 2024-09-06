package fpc.aoc.robot;

import lombok.NonNull;

public interface StateUpdater<O,S> {

    @NonNull
    S createInitialState();

    @NonNull
    S updateStateOnReply(@NonNull S current, @NonNull Order<O> lastSendOrder, @NonNull String reply);
}
