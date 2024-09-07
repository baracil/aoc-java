package fpc.aoc.computer.io;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Nil;
import fpc.aoc.computer.io._private.InputPort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Scanner;

/**
 * @author Bastien Aracil
 **/
@RequiredArgsConstructor
public class StdinInputPort implements InputPort<Nil> {

    @NonNull
    private final InputMultiTransformer<String> transformer;

    private final Scanner scanner = new Scanner(System.in);

    private List<String> current = null;

    private int index = 0;

    @Override
    public @NonNull String read() {
        if (current == null || index>=current.size()) {
            index = 0;
            final String line = scanner.nextLine();
            if (line.equals("exit")) {
                throw new AOCException("Exit requested");
            }
            current = transformer.apply(line+"\n");
        }
        return current.get(index++);
    }

    @Override
    public Nil programInputAccessor() {
        return Nil.NIL;
    }
}
