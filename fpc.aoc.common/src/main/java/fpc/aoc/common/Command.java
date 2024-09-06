package fpc.aoc.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Command {
    LEFT("L"),
    RIGHT("R"),
    ;

    private final String code;

}
