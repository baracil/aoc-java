package fpc.aoc.year2020.day19.structures;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Pair;
import lombok.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@RequiredArgsConstructor
@Builder
public class Day19Input {

    @Singular
    @Getter
    private final @NonNull Map<Integer, Rule> rules;

    @Singular
    @Getter
    private final @NonNull List<String> messages;


    /** PARSING **/
    public static @NonNull Day19Input parse(@NonNull String string) {
        return parse(Arrays.stream(string.split("\n")).toList());
    }

    public static @NonNull Day19Input parse(List<String> strings) {
        final var builder = Day19Input.builder();
        Consumer<String> parser = string -> {
            final var pair = parseRule(string);
            builder.rule(pair.first(),pair.second());
        };
        for (String string : strings) {
            if (string.isBlank()) {
                parser = builder::message;
                continue;
            }
            parser.accept(string);
        }
        return builder.build();
    }

    private static Pair<Integer,Rule> parseRule(@NonNull String ruleAsString) {
        try {
            final int idx = ruleAsString.indexOf(":");
            final int ruleId = Integer.parseInt(ruleAsString.substring(0, idx));
            final Rule rule = Rule.parse(ruleAsString.substring(idx + 1));
            return Pair.of(ruleId, rule);
        } catch (Exception e) {
            throw new AOCException("Could not parse '"+ruleAsString+"'",e);
        }
    }


    public @NonNull Rule findRule(int id) {
        return rules.get(id);
    }

    public Day19Input replaceRules(@NonNull Map<Integer, Rule> newRules) {
        final Map<Integer,Rule> rules = new HashMap<>();
        for (Map.Entry<Integer, Rule> entry : this.rules.entrySet()) {
            rules.put(entry.getKey(), newRules.getOrDefault(entry.getKey(),entry.getValue()));
        }
        return new Day19Input(rules,messages);
    }
}
