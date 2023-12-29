package fpc.aoc.year2022.day21;

import java.util.regex.Pattern;

public interface Monkey {

    String name();

    record NumberYeller(String name, long value) implements Monkey {

    }

    record OperationYeller(String name, String n1, String n2, Operator operator) implements Monkey {

    }

    Pattern PATTERN = Pattern.compile("(?<n1>[a-z]+) *(?<op>[-+*/]) *(?<n2>[a-z]+)");

    static Monkey parse(String line) {
        final var tokens = line.split(":");

        final var matcher = PATTERN.matcher(tokens[1].trim());
        if (matcher.matches()) {
            return new OperationYeller(tokens[0].trim(), matcher.group("n1"),matcher.group("n2"), Operator.parse(matcher.group("op")));
        } else {
            return new NumberYeller(tokens[0].trim(),Integer.parseInt(tokens[1].trim()));
        }
    }

}
