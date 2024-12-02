package fpc.aoc.year2019.day14.computation;

import fpc.aoc.year2019.day14.computation.parser.ParsedChemicalBook;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ChemicalBook {

    @NonNull
    private final Map<String,Chemical> chemicalByName;

    @NonNull
    private final Map<Chemical,ChemicalReaction> reactions;


    @NonNull
    public Chemical getOre() {
        return chemicalByName.get("ORE");
    }

    @NonNull
    public Chemical fuel() {
        return chemicalByName.get("FUEL");
    }

    @NonNull
    public ChemicalReaction getReactionProducing(Chemical chemical) {
        return reactions.get(chemical);
    }

    public static Collector<String,?,ChemicalBook> collector() {
        return Collectors.collectingAndThen(
                ParsedChemicalBook.collector(),
                ParsedChemicalBook::createBook
        );
    }


}
