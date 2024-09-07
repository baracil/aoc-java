package fpc.aoc.year2019.day21;

import fpc.aoc.year2019.day21._private.TriBool;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Bastien Aracil
 **/
@Getter
@RequiredArgsConstructor
public enum  Action {
    JUMP(TriBool.TRUE, "J"),
    DO_NOT_JUMP(TriBool.FALSE,"."),
    IT_DEPENDS(TriBool.ANY,"?"),
    ITS_OVER(TriBool.ANY,"X"),
    ;

    private final TriBool triBool;

    private final String representation;
}
