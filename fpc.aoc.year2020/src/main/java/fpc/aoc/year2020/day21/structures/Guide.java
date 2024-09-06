package fpc.aoc.year2020.day21.structures;

import fpc.aoc.common.Bag;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;

@Getter
@RequiredArgsConstructor
public class Guide {

  private final @NonNull Map<Allergen, Ingredient> allergenIdentification;

  private final @NonNull Set<Ingredient> safeIngredients;

  private final @NonNull Bag<Ingredient> bagOfIngredients;

  public static Collector<String, ?, Guide> collector() {
    return Collector.of(
        GuideBuilder::new,
        (b, s) -> b.addFood(Food.parse(s)),
        GuideBuilder::combine,
        GuideBuilder::buildGuide
    );


  }
}
