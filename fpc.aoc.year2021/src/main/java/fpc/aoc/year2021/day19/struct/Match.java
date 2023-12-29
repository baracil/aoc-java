package fpc.aoc.year2021.day19.struct;

import lombok.NonNull;

public record Match(int rotationIdx, @NonNull Vector offset, int nbMatch) {
}
