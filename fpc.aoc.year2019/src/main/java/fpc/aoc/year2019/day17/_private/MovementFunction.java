package fpc.aoc.year2019.day17._private;

import fpc.aoc.common.AOCException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MovementFunction {
    A("A"),
    B("B"),
    C("C"),
;

    public boolean hasNext() {
        return this!=C;
    }

    @NonNull
    public MovementFunction next() {
      return switch (this) {
        case A -> B;
        case B -> C;
        default -> throw new AOCException("No more function available");
      };
    }
    private final String code;

    public MovementFunction nextOrNull() {
        if (hasNext()) {
            return next();
        }
        return null;
    }
}
