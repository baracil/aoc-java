package fpc.aoc.year2019.day11.computation;

import fpc.aoc.common.EnumHelper;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Color {
    BLACK("0", Instruction.PAINT_BLACK),
    WHITE("1", Instruction.PAINT_WHITE),
    ;

    @NonNull
    private final String code;

    @NonNull
    private final Instruction instruction;

    @NonNull
    public static Color decode(@NonNull String code) {
        return Holder.HELPER.get(code);
    }

    private static class Holder {

        private static final EnumHelper<String,Color> HELPER = EnumHelper.create(Color.class,c -> c.code);
    }
}
