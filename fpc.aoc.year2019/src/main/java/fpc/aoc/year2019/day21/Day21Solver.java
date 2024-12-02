package fpc.aoc.year2019.day21;

import fpc.aoc.common.Nil;
import fpc.aoc.computer.Execution;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.computer.io.InputMultiTransformer;
import fpc.aoc.computer.io.ProgramIO;
import fpc.aoc.computer.io.ProgramInput;
import fpc.aoc.year2019.day21._private.JumpTable;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class Day21Solver extends ProgramBasedSolver {


    @Override
    protected Object doSolve(Program program) {
        return solve(l -> execute(program,l));
    }

    private void printLogicalExpression() {
        final JumpTable jumpTable = JumpTable.create(sensorRange());
        System.out.println(jumpTable.createLogicalExpression());
    }

    abstract int solve(Function<List<String>,Result> executor);

    abstract int sensorRange();

    abstract String launchCommand();


    private Result execute(Program program, List<String> commands) {
        final OutputConsumer outputConsumer = new OutputConsumer(sensorRange());
        final String launchCommand = launchCommand();

        final Execution<ProgramInput<String>, Nil> execution;
        execution = program.launch("Hull inspection", ProgramIO.controlledInput(InputMultiTransformer.TO_ASCII).consumeWith(outputConsumer));

        final ProgramInput<String> input = execution.programInputAccessor();

        Stream.concat(
                commands.stream(),
                Stream.of(launchCommand)
        ).forEach(s -> {
            input.write(s);
            input.write("\n");
        });

        execution.waitTermination();

        return outputConsumer.getResult();
    }

    @RequiredArgsConstructor
    public static class Result {

        @Getter
        private final int damage;

        @NonNull
        @Getter
        private final List<String> outputLines;

        private final int lastSensor;

        public boolean isSuccess() {
            return lastSensor < 0;
        }

        @NonNull
        public OptionalInt lastSensor() {
            return lastSensor<0?OptionalInt.empty():OptionalInt.of(lastSensor);
        }

    }



    @RequiredArgsConstructor
    public static class OutputConsumer implements Consumer<String> {

        private final int size;

        @Getter
        private int damage = -1;

        private final ByteArrayOutputStream out = new ByteArrayOutputStream(1000);

        @Override
        public void accept(String s) {
            onData(s);
        }

        public void onData(String data) {
            final int v = Integer.parseInt(data);
            if (v >= 0 && v < 256) {
                out.write(v);
            }
            else {
                damage = v;
            }
        }

        private List<String> lines() {
            final String[] lines = out.toString(StandardCharsets.US_ASCII).split("\n");
            return List.of(lines);
        }

        private int lastSensor(List<String> lines) {
            if (damage>0) {
                return -1;
            }
            final String line = lines.getLast();
            final int idx = line.indexOf("@");
            if (idx > 0) {
                final String sensor = line.substring(idx - size+1, idx - size+1 + size);
                return IntStream.range(0, size)
                                .filter(i -> (sensor.charAt(i) == '#'))
                                .map(i -> 1 << i)
                                .sum();
            }
            return -1;
        }

        private Result getResult() {
            final var lines = lines();
            return new Result(damage, lines, lastSensor(lines));
        }



    }

}
