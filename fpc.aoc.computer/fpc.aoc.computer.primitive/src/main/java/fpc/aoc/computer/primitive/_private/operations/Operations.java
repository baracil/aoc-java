package fpc.aoc.computer.primitive._private.operations;

public class Operations {

    public static final Operation ADD = new BinaryOperation(Long::sum);

    public static final Operation MULTIPLY = new BinaryOperation((a,b)-> a * b);

    public static final Operation OUTPUT = new OutputOperation();

    public static final Operation INPUT = new InputOperation();

    public static final Operation JUMP_IF_TRUE = new JumpOperation(i -> i != 0L);

    public static final Operation JUMP_IF_FALSE = new JumpOperation(i -> i == 0L);

    public static final Operation LESS_THAN = new BinaryOperation((a,b) -> a < b ? 1 : 0);

    public static final Operation EQUALS = new BinaryOperation((a,b) -> a == b ? 1 : 0);

    public static final Operation ADJUST_RELATIVE_BASE = new AdjustRelativeBase();

}
