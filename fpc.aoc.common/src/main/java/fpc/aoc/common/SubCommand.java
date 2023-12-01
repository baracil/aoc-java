package fpc.aoc.common;

import lombok.NonNull;

public sealed interface SubCommand {

    static @NonNull SubCommand parse(@NonNull String commandAsString) {
        final var tokens = commandAsString.trim().split(" ", 2);

        if (tokens.length == 2) {
            final var amount = Integer.parseInt(tokens[1]);
            switch (tokens[0]) {
                case "forward" : return new Forward(amount);
                case "up" : return new Up(amount);
                case "down" : return new Down(amount);
            }
        }
        throw new IllegalArgumentException("Cannot parse command : '" + commandAsString + "'");
    }

    record Forward(int amount) implements SubCommand {
    }

    record Down(int amount) implements SubCommand {
    }

    record Up(int amount) implements SubCommand {
    }
}
