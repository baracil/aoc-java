package fpc.aoc.year2020.day8.structures;

import lombok.NonNull;

public interface StopCondition {

    boolean shouldStopExecution(@NonNull ExecutionContext executionContext);
}
