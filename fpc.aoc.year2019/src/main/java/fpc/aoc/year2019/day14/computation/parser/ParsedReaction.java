package fpc.aoc.year2019.day14.computation.parser;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Tools;
import fpc.aoc.year2019.day14.computation.Chemical;
import fpc.aoc.year2019.day14.computation.ChemicalReaction;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ParsedReaction {

    @NonNull
    private final ReactionToken produced;

    @NonNull
    private final List<ReactionToken> reactants;

    public ParsedReaction(String reaction) {
        try {
            final String[] inputOutputSplit = reaction.split("=>");
            this.produced = new ReactionToken(inputOutputSplit[1].trim());
            this.reactants = Arrays.stream(inputOutputSplit[0].split(",")).map(ReactionToken::new).toList();
        } catch (Exception e) {
            throw new AOCException("Could not parse reaction '" + reaction + "'");
        }
    }

    @NonNull
    public ChemicalReaction toChemicalReaction(Map<String, Chemical> chemicalByName) {
        return new ChemicalReaction(
                chemicalByName.get(produced.name()),
                produced.amount(),
                Tools.map(reactants, r ->r.toReactant(chemicalByName))
                );
    }

    @NonNull
    public Stream<String> reactantNames() {
        return reactants.stream().map(ReactionToken::name);
    }

    @NonNull
    public String producedChemicalName() {
        return produced.name();
    }

}
