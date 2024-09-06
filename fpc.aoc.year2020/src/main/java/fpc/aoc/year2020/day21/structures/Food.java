package fpc.aoc.year2020.day21.structures;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class Food {

  public static @NonNull Food parse(@NonNull String line) {
    final int idxOfAllergens = line.indexOf("(contains ");
    final String ingredientsPart;
    final String allergensPart;
    if (idxOfAllergens < 0) {
      ingredientsPart = line.trim();
      allergensPart = "";
    } else {
      ingredientsPart = line.substring(0, idxOfAllergens);
      allergensPart = line.trim().substring(idxOfAllergens + "(contains ".length(), line.length() - 1);
    }

    return new Food(
        Arrays.stream(ingredientsPart.split(" ")).map(Ingredient::new).collect(Collectors.toSet()),
        allergensPart.isEmpty() ? Set.of() : Arrays.stream(allergensPart.split(","))
            .map(String::trim)
            .map(Allergen::new)
            .collect(Collectors.toSet())
    );
  }

  private final @NonNull Set<Ingredient> ingredients;
  private final @NonNull Set<Allergen> allergens;

  @Override
  public String toString() {
    return ingredients.stream().map(Ingredient::name).collect(Collectors.joining(" "))
        + allergens.stream().map(Allergen::name).collect(Collectors.joining(", ", " (contains ", ")"));
  }

}
