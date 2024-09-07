package fpc.aoc.year2019.day20._private;

import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Bastien Aracil
 **/
@Getter
@RequiredArgsConstructor
public class Teletransporter {

    @NonNull
    private final Position from;

    @NonNull
    private final Position to;

    private final boolean goesDeeper;

}
