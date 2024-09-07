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
public class Portal {

    @NonNull
    private final String name;

    @NonNull
    private final Position entrance;

    @NonNull
    private final Position exit;

    private final boolean inside;

}
