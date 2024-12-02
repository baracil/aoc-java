package fpc.aoc.year2019.day14.computation.parser;

import fpc.aoc.common.AOCException;
import fpc.aoc.year2019.day14.computation.Chemical;
import fpc.aoc.year2019.day14.computation.Reactant;
import lombok.Getter;
import lombok.NonNull;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class ReactionToken {

    private static final Pattern PRODUCT = Pattern.compile("(\\d+) +([A-Z]+)");

    private final String name;

    private final int amount;

    @NonNull
    public Reactant toReactant(Map<String, Chemical> chemicalByName) {
        return new Reactant(chemicalByName.get(name),amount);
    }

    public ReactionToken(String token) {
        final Matcher matcher = PRODUCT.matcher(token.trim());
        if (!matcher.matches()) {
            throw new AOCException("Cannot parse token : '" + token + "'");
        }
        this.name = matcher.group(2);
        this.amount = Integer.parseInt(matcher.group(1));
    }

}
