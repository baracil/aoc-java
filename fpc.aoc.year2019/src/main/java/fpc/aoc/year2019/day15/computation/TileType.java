package fpc.aoc.year2019.day15.computation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum  TileType {
    WALL("█"),
    EMPTY(" "),
    START("*"),
    OXYGEN("o"),
    UNKNOWN("?")
    ;

    public boolean canWalkThere() {
        return this == EMPTY || this == OXYGEN || this == START;
    }

    @NonNull
    private final String representation;
}
