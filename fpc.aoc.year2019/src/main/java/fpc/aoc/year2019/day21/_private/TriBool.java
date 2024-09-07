package fpc.aoc.year2019.day21._private;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Bastien Aracil
 **/
@Getter
@RequiredArgsConstructor
public enum  TriBool {
    TRUE("T"),
    FALSE("F"),
    ANY("A"),
    ;

    private final String code;

    public boolean isSimilarTo(TriBool value) {
        if (this == ANY || value == ANY) {
            return true;
        }
        return this == value;
    }

    @NonNull
    public TriBool compose(@NonNull TriBool other) {
      return switch (other) {
        case TRUE -> TRUE;
        case FALSE -> FALSE;
        default -> this;
      };
    }
}
