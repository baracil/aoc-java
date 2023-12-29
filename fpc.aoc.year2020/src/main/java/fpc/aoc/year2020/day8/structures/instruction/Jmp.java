package fpc.aoc.year2020.day8.structures.instruction;

import fpc.aoc.year2020.day8.structures.ComplexInstructionVisitor;
import fpc.aoc.year2020.day8.structures.Instruction;
import fpc.aoc.year2020.day8.structures.InstructionVisitor;
import fpc.aoc.year2020.day8.structures.Operation;
import lombok.NonNull;
import lombok.Value;

@Value
public class Jmp implements Instruction {

    public static Jmp parse(@NonNull String argument) {
        return new Jmp(Integer.parseInt(argument));
    }

    int offset;

    @Override
    public <P,T> T accept(@NonNull ComplexInstructionVisitor<P,T> visitor, @NonNull P parameter) {
        return visitor.visit(this,parameter);
    }

    @Override
    public <T> @NonNull T accept(@NonNull InstructionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public @NonNull Operation getOperation() {
        return Operation.JMP;
    }
}
