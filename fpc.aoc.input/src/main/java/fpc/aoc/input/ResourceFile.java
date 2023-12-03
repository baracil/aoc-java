package fpc.aoc.input;

import fpc.aoc.api.Day;
import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class ResourceFile implements Input<Stream<String>> {

    @NonNull
    private final String resourceName;

    public ResourceFile(@NonNull Day day) {
        this(day.getInputFileName());
    }

    @Override
    public @NonNull Stream<String> readData() {
        final InputStream inputStream = Input.class.getResourceAsStream(resourceName);
        if (inputStream == null) {
            throw new AOCException("Could not find input file '" + resourceName + "'");
        }

        final BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        try {
            final Stream<String> stream = bfr.lines();
            return stream.onClose(() -> {
                try {
                    bfr.close();
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
        } catch (RuntimeException | Error e) {
            try {
                bfr.close();
            } catch (IOException io) {
                e.addSuppressed(io);
            }
            throw e;
        }
    }
}
