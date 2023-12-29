package fpc.aoc.year2020.day16;

import fpc.aoc.common.AOCException;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Builder
public class Input {

    @Singular
    @Getter
    private final @NonNull Set<Field> fields;
    @Singular
    private final @NonNull List<Ticket> tickets;


    public @NonNull List<Ticket> allTickets() {
        return tickets;
    }

    public @NonNull Ticket myTicket() {
        return tickets.getFirst();
    }

    public int numberOfFields() {
        return fields.size();
    }

    public @NonNull Stream<Ticket> streamNearByTickets() {
        return tickets.stream().skip(1);
    }

    public static @NonNull Input parse(@NonNull List<String> lines) {
        final var builder = Input.builder();

        Consumer<String> parser = l -> builder.field(Field.parse(l));
        for (int i = 0, linesSize = lines.size(); i < linesSize; i++) {
            String line = lines.get(i);
            if (line.isBlank()) {
                parser = null;
            } else if (line.equals("your ticket:")) {
                parser = l -> builder.ticket(Ticket.parse(l));
            } else if (line.equals("nearby tickets:")) {
                parser = l -> builder.ticket(Ticket.parse(l));
            } else if (parser == null) {
                throw new AOCException("No parser available for line #" + i + "'" + line + "'");
            } else {
                parser.accept(line);
            }
        }

        return builder.build();
    }

}
