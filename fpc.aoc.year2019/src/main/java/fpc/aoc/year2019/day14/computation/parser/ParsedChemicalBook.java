package fpc.aoc.year2019.day14.computation.parser;

import fpc.aoc.year2019.day14.computation.Chemical;
import fpc.aoc.year2019.day14.computation.ChemicalBook;
import fpc.aoc.year2019.day14.computation.ChemicalReaction;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ParsedChemicalBook {

  private static final Collector<Map.Entry<String, Integer>, ?, Map<String, Chemical>> CHEMICAL_COLLECTOR =
      Collectors.toUnmodifiableMap(Map.Entry::getKey, e -> new Chemical(e.getKey(), e.getValue()));


  @NonNull
  private Map<String, ParsedReaction> reactions;

  @NonNull
  public ChemicalBook createBook() {
    final Map<String, Chemical> chemicalByName = createChemicals();
    final Map<Chemical, ChemicalReaction> chemicalReactions;
    {

      chemicalReactions = reactions.values()
          .stream()
          .map(r -> r.toChemicalReaction(chemicalByName))
          .collect(Collectors.toUnmodifiableMap(ChemicalReaction::producedChemical, r -> r));
    }

    return new ChemicalBook(chemicalByName, chemicalReactions);


  }

  private Map<String, Chemical> createChemicals() {
    final Map<String, Integer> complexities = new HashMap<>();
    complexities.put("ORE", 0);
    computeComplexity("FUEL", complexities);

    return complexities.entrySet()
        .stream()
        .collect(CHEMICAL_COLLECTOR);
  }

  private int computeComplexity(String chemicalName, Map<String, Integer> complexities) {
    Integer complexity = complexities.get(chemicalName);
    if (complexity == null) {
      complexity = reactions.get(chemicalName)
                       .reactantNames()
                       .mapToInt(n -> computeComplexity(n, complexities))
                       .max()
                       .orElseThrow() + 1;

      complexities.put(chemicalName, complexity);
    }
    return complexity;
  }


  public static Collector<String, ?, ParsedChemicalBook> collector() {
    return Collectors.collectingAndThen(
        Collectors.mapping(
            ParsedReaction::new,
            Collectors.toUnmodifiableMap(ParsedReaction::producedChemicalName, r -> r)
        ),
        ParsedChemicalBook::new
    );
  }

}
