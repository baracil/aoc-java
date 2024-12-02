package fpc.aoc.year2019.day21._private;

import fpc.aoc.year2019.day21.Action;
import fpc.aoc.year2019.day21.SpecificCases;
import lombok.NonNull;

import java.util.Optional;
import java.util.function.BiFunction;

/**
 * @author Bastien Aracil
 **/
public class JumpTableBuilder {


    public static JumpTable create(BiFunction<Integer, Action[],JumpTable> constructor, int targetSize) {
        return new JumpTableBuilder(constructor,targetSize).compute();
    }

    @NonNull
    private final BiFunction<Integer,Action[],JumpTable> constructor;

    private final int targetSize;

    private final Action[][] tables;

    private JumpTableBuilder(BiFunction<Integer,Action[],JumpTable> constructor, int targetSize) {
        this.constructor = constructor;
        this.targetSize = targetSize;
        this.tables = new Action[targetSize+1][];
        this.tables[4] = createTable4();
    }

    public JumpTable compute() {
        for (int size = 5; size <= targetSize; size++) {
            tables[size] = createTable(size);
        }
        return constructor.apply(targetSize,tables[targetSize]);
    }

    public Action[] createTable(int size) {
        assert size>4 && (tables[size-1] != null);
        final Action[] actions = new Action[1<<size];
        for (int i = 0; i < actions.length; i++) {
            final boolean aHasGround = SensorRegistry.A.isSet(i);
            final boolean dHasGround = SensorRegistry.D.isSet(i);
            final boolean eHasGround = SensorRegistry.E.isSet(i);

            final Optional<Action> specificCase = SpecificCases.getSpecificCases(size,i);
            if (specificCase.isPresent()) {
                actions[i] = specificCase.get();
            }
            else if (!aHasGround && !dHasGround) {
                actions[i] = Action.ITS_OVER;
            } else {
                final Action actionAfterNoJump;
                final Action actionAfterJump;

                actionAfterNoJump = evaluate(size-1, i>>1);
                if (!dHasGround) {
                    actionAfterJump = Action.ITS_OVER;
                }
                else if (size>=8) {
                    actionAfterJump = evaluate(size - 4,i>>4);
                } else {
                    actionAfterJump = eHasGround?Action.IT_DEPENDS:Action.JUMP;
                }

                if (aHasGround) {
                    actions[i] = mergeAction(actionAfterJump,actionAfterNoJump);
                } else {
                    actions[i] = actionAfterJump == Action.ITS_OVER ? Action.ITS_OVER : Action.JUMP;
                }


            }
        }
        return actions;
    }

    private Action mergeAction(Action afterJump, Action afterNoJump) {
        if (afterJump == Action.ITS_OVER && afterNoJump == Action.ITS_OVER) {
            return Action.ITS_OVER;
        }
        if (afterJump == Action.ITS_OVER) {
            return Action.DO_NOT_JUMP;
        }
        else if (afterNoJump == Action.ITS_OVER) {
            return Action.JUMP;
        }
        return Action.IT_DEPENDS;
    }

    public Action evaluate(int size, int value) {
        return tables[size][value];
    }


    private static Action[] createTable4() {
        final Action[] actions = new Action[16];
        for (int i = 0; i < actions.length; i++) {
            boolean aHasGround = SensorRegistry.A.isSet(i);
            boolean dHasGround = SensorRegistry.D.isSet(i);
            if (!aHasGround) {
                actions[i] = dHasGround?Action.JUMP:Action.ITS_OVER;
            }
            else {
                actions[i] = dHasGround?Action.IT_DEPENDS:Action.DO_NOT_JUMP;
            }
            actions[i] = SpecificCases.getSpecificCases(4,i).orElse(actions[i]);
        }
        return actions;
    }
}
