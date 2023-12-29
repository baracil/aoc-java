package fpc.aoc.year2023.day20.model;

import fpc.aoc.year2023.day20.model.state.CircuitState;

public record ExecutionResult(long nbLow, long nbHigh, CircuitState state) {
}
