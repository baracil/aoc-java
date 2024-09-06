package fpc.aoc.year2019.day11.computation;

import fpc.aoc.common.EnumHelper;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TurnDirection {
    LEFT("0", Instruction.TURN_LEFT),
    RIGHT("1", Instruction.TURN_RIGHT),
    ;

    private final String code;

    @NonNull
    private final Instruction instruction;

    @NonNull
    public static TurnDirection decode(String code) {
        return Holder.HELPER.get(code);
    }

    private static class Holder {

        private static final EnumHelper<String,TurnDirection> HELPER = EnumHelper.create(TurnDirection.class, t->t.code);
    }
}
