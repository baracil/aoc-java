package fpc.aoc.year2019.day21._private;

import fpc.aoc.year2019.day21.Action;
import lombok.Getter;
import lombok.NonNull;

import java.io.PrintStream;
import java.util.stream.IntStream;

/**
 * @author Bastien Aracil
 **/
public class JumpTable implements TruthTable {

    @NonNull
    public static JumpTable create(int size) {
        return JumpTableBuilder.create(JumpTable::new,size);
    }

    @Getter
    private final int size;

    @NonNull
    private final Action[] actions;

    private JumpTable(int size, @NonNull Action[] actions) {
        this.size = size;
        this.actions = actions;
    }

    public Action action(int value) {
        return actions[value];
    }

    @Override
    public int nbParameters() {
        return size;
    }

    @Override
    public @NonNull TriBool value(int parameters) {
        return actions[parameters].triBool();
    }

    public void print(@NonNull PrintStream ps) {
        IntStream.range(0,actions.length)
                 .mapToObj(this::oneActionLine)
                 .sorted()
                 .forEach(ps::println);
    }

    @NonNull
    public String createLogicalExpression() {
        return new Node(this).simplify().expression(SensorRegistry.parameterNames());
    }

    private String oneActionLine(int index) {
        return String.format("%2$s   %1$s",actions[index].representation(),formFloor(index));
    }

    private String formFloor(int value) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            final boolean set = (value&(1<<i))!=0;
            sb.append(set?'#':'.');
        }
        return sb.toString();
    }
}
