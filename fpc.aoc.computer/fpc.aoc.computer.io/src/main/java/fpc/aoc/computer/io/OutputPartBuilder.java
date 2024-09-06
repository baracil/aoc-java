package fpc.aoc.computer.io;

import fpc.aoc.common.Nil;
import fpc.aoc.computer.io._private.ComposedProgramIO;
import fpc.aoc.computer.io._private.InputPort;
import fpc.aoc.computer.io._private.output.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class OutputPartBuilder<I> {

    @NonNull
    private final InputPort<I> inputPort;

    public <W> ProgramIO<I,Optional<W>> lastValue(@NonNull OutputTransformer<W> transformer) {
        return new ComposedProgramIO<>(inputPort, new LastValueOutputPort<>(transformer));
    }

    @NonNull
    public ProgramIO<I,Optional<String>> lastValue() {
        return lastValue(OutputTransformer.NONE);
    }

    @NonNull
    public ProgramIO<I,ProgramOutput<String>> controlledOutput() {
        return controlledOutput(OutputTransformer.NONE);
    }

    @NonNull
    public <W> ProgramIO<I,ProgramOutput<W>> controlledOutput(@NonNull OutputTransformer<W> transformer) {
        return new ComposedProgramIO<>(inputPort, new ControllerOutputPort<>(transformer));
    }

    @NonNull
    public ProgramIO<I,Nil> ignoreOutput() {
        return new ComposedProgramIO<>(inputPort, new IgnoreOutputPort());
    }

    @NonNull
    public ProgramIO<I,Nil> toStdout() {
        return toStdout(OutputTransformer.NONE);
    }

    @NonNull
    public <T> ProgramIO<I,Nil> toStdout(@NonNull OutputTransformer<T> transformer) {
        return new ComposedProgramIO<>(inputPort, new ToSdtOutputPort<>(transformer));
    }

    @NonNull
    public <T> ProgramIO<I,List<T>> toList(@NonNull OutputTransformer<T> transformer) {
        return new ComposedProgramIO<>(inputPort, new ToListOutputPort<>(transformer));
    }

    @NonNull
    public ProgramIO<I,List<String>> toList() {
        return new ComposedProgramIO<>(inputPort, new ToListOutputPort<>(OutputTransformer.NONE));
    }

    @NonNull
    public ProgramIO<I,Nil> consumeWith(@NonNull Consumer<? super String> consumer) {
        return new ComposedProgramIO<>(inputPort, new SimpleConsumeOutput(consumer));
    }

    @NonNull
    public <T> ProgramIO<I,Nil> consumeWith(@NonNull Consumer<? super T> consumer,@NonNull OutputTransformer<T> transformer) {
        return consumeWith(s->consumer.accept(transformer.transform(s)));
    }

}
