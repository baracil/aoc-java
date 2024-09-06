package fpc.aoc.computer.primitive._private;

import fpc.aoc.common.Tools;
import fpc.aoc.computer.common.AccessMode;
import fpc.aoc.computer.common.AccessModeVisitor;
import fpc.aoc.computer.common.Addressing;
import fpc.aoc.computer.common.Modes;
import fpc.aoc.computer.io.ProgramIO;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ExecutionContext implements ParameterAccessor {

    @Getter
    private final String executionName;

    @NonNull
    private final Memory memory;

    private final ProgramIO<?,?> programIo;

    private final AbsoluteAddressGetter absoluteAddressGetter = new AbsoluteAddressGetter();

    private Modes modes;

    private Addressing addressing;

    private final List<String> outputBuilder = new ArrayList<>();

    public long readFromInput() {
        return Long.parseLong(programIo.read());
    }

    public void writeToOutput(long value) {
        final String str = Long.toString(value);
        outputBuilder.add(str);
        programIo.write(str);
    }

    @Override
    public long getParameter(int position) {
        final AccessMode mode = modes.accessMode(position);
        int address = mode.accept(absoluteAddressGetter, position + addressing.absoluteBase());
        return memory.getValueAt(address);
    }


    @Override
    public void setParameter(int position,long value) {
        final AccessMode mode = modes.accessMode(position);
        int address = mode.accept(absoluteAddressGetter, position + addressing.absoluteBase());
        memory.setValue(address,value);
    }

    public void initBeforeExecution(@NonNull Addressing addressing, @NonNull Modes modes) {
        this.modes = modes;
        this.addressing = addressing;
    }

    public List<String> listOfOutputs() {
        return new ArrayList<>(outputBuilder);
    }

    private class AbsoluteAddressGetter implements AccessModeVisitor {

        @Override
        public int visitImmediate(int absoluteAddress) {
            return absoluteAddress;
        }

        @Override
        public int visitRelative(int absoluteAddress) {
            final long value = memory.getValueAt(absoluteAddress);
            return Tools.toInt(addressing.relativeBase()+value);
        }

        @Override
        public int visitPosition(int absoluteAddress) {
            return Tools.toInt(memory.getValueAt(absoluteAddress));
        }
    }
}
