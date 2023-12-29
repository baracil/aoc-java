package fpc.aoc.year2020.day21.structures;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Bag;
import fpc.aoc.common.HashBag;
import fpc.aoc.common.Tools;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GuideBuilder {


  private final @NonNull Map<Allergen, Set<Ingredient>> potentialAllergens = new HashMap<>();

  private final @NonNull Map<Ingredient, Set<Allergen>> ingredientAllergen = new HashMap<>();

  private final Bag<Ingredient> bagOfIngredients = new HashBag<>();

  public Guide buildGuide() {
    cleanUp();
    final var allergenIdentification = potentialAllergens.entrySet()
        .stream()
        .peek(e -> {
          if (e.getValue().size() != 1) {
            throw new AOCException("Guide is not resolved for allergen " + e.getKey());
          }
        }).collect(Collectors.toMap(Map.Entry::getKey, e -> Tools.getOneElement(e.getValue())));

    return new Guide(allergenIdentification, Set.copyOf(ingredientAllergen.keySet()), bagOfIngredients);
  }

  public void addFood(@NonNull Food food) {
    food.allergens().forEach(a -> {
      final Set<Ingredient> existing = potentialAllergens.get(a);
      if (existing == null) {
        potentialAllergens.put(a, new HashSet<>(food.ingredients()));
      } else {
        existing.removeIf(e -> !food.ingredients().contains(e));
      }
    });

    food.ingredients().forEach(i -> {
      bagOfIngredients.addOne(i);
      ingredientAllergen.computeIfAbsent(i, x -> new HashSet<>()).addAll(food.allergens());
    });
  }

  private void cleanUp() {
    Set<Allergen> candidates = potentialAllergens.entrySet()
        .stream()
        .filter(e -> e.getValue().size() == 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());
    while (!candidates.isEmpty()) {
      candidates = candidates.stream()
          .map(this::cleanOneAllergens)
          .flatMap(Collection::stream)
          .collect(Collectors.toSet());
    }
  }

  public @NonNull Set<Allergen> cleanOneAllergens(@NonNull Allergen allergen) {
    final Set<Allergen> nextCandidateForCleanUp = new HashSet<>();

    final Ingredient associatedIngredient = potentialAllergens.get(allergen)
        .stream()
        .findFirst()
        .orElseThrow(() -> new AOCException("THIS IS A BUG !!"));

    Optional.ofNullable(ingredientAllergen.remove(associatedIngredient))
        .stream()
        .flatMap(Collection::stream)
        .filter(a -> !a.equals(allergen))
        .forEach(a -> {
          final var ingredients = potentialAllergens.get(a);
          if (ingredients != null) {
            ingredients.remove(associatedIngredient);
            if (ingredients.size() == 1) {
              nextCandidateForCleanUp.add(a);
            }
          }
        });

    return nextCandidateForCleanUp;

  }

  public @NonNull GuideBuilder combine(GuideBuilder builder) {
    builder.potentialAllergens.forEach((a, s) -> potentialAllergens.computeIfAbsent(a, x -> new HashSet<>()).addAll(s));
    builder.ingredientAllergen.forEach((i, s) -> ingredientAllergen.computeIfAbsent(i, x -> new HashSet<>()).addAll(s));
    return this;
  }
}
