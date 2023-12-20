package fpc.aoc.day20.model;

import fpc.aoc.day20.model.state.CircuitState;

public record ExecutionResult(long nbLow, long nbHigh, CircuitState state){
}
