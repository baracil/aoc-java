package fpc.aoc.computer;

import fpc.aoc.common.AOCException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class ExecutionResult {

    @NonNull
    private final MemoryAccessors memoryAccessors;

    @NonNull
    @Getter
    private final List<String> outputs;


    public String getFirstValueOfMemory() {
        return memoryAccessors.getValueAt(0);
    }

    public int numberOfOutput() {
        return outputs.size();
    }

    @NonNull
    public String getLastOutput() {
        if (outputs.isEmpty()) {
            throw new AOCException("No output");
        }
        return outputs.get(outputs.size()-1);
    }

    @NonNull
    public String dumpMemory() {
        return memoryAccessors.dumpMemory();
    }

    public void forEachOutput(@NonNull Consumer<? super String> consumer) {
        outputs.forEach(consumer);
    }
}
