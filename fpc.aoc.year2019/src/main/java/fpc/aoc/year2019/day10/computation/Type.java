package fpc.aoc.year2019.day10.computation;

import fpc.aoc.common.CodedEnumHelper;
import fpc.aoc.common.Encoded;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type implements Encoded {
    EMPTY('.'),
    ASTEROID('#'),
    ;

    private final int code;

    private final String representation;

    Type(char code) {
        this.code = code;
        this.representation = String.valueOf(code);
    }

    @NonNull
    public static Type getType(int code) {
        return Holder.HELPER.get(code);
    }

    private static class Holder {
        private static final CodedEnumHelper<Type> HELPER = CodedEnumHelper.create(Type.class);

    }
}
