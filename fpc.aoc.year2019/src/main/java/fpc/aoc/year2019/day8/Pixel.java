package fpc.aoc.year2019.day8;

import fpc.aoc.common.CodedEnumHelper;
import fpc.aoc.common.Encoded;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Pixel implements Encoded {
    D0_BLACK(0," "),
    D1_WHITE(1, "█"),
    D2_TRANSPARENT(2,".") {
        @Override
        public @NonNull Pixel stack(@NonNull Pixel pixelBelow) {
            return pixelBelow;
        }
    },
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    ;

    private final int code;

    private final String representation;

    Pixel(int code) {
        this(code,code+"");
    }

    @NonNull
    public Pixel stack(@NonNull Pixel pixelBelow) {
        return this;
    }

    @NonNull
    public static Pixel get(int value) {
        return Holder.HELPER.get(value);
    }

    private static class Holder {

        public static final CodedEnumHelper<Pixel> HELPER = CodedEnumHelper.create(Pixel.class);
    }
}
