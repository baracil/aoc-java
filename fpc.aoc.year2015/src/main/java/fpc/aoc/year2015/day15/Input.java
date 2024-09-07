package fpc.aoc.year2015.day15;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.LongPredicate;
import java.util.function.ToIntFunction;

@RequiredArgsConstructor
public class Input {
  private final int[] capacity;
  private final int[] durability;
  private final int[] flavor;
  private final int[] texture;
  private final int[] calories;


  public long getProd(LongPredicate validCalorie) {
    final int nbItems = calories.length;

    long maxProd = 0;
    Index index = new Index(nbItems, 100);

    do {
      var capacitySum = 0L;
      var durabilitySum = 0L;
      var flavorSum = 0L;
      var textureSum = 0L;
      var caloriesSum = 0L;
      for (int i = 0; i < nbItems; i++) {
        final var factor = index.factor(i);
        capacitySum += capacity[i] * factor;
        durabilitySum += durability[i] * factor;
        flavorSum += flavor[i] * factor;
        textureSum += texture[i] * factor;
        caloriesSum += calories[i] * factor;
      }
      capacitySum = Math.max(capacitySum, 0);
      durabilitySum = Math.max(durabilitySum, 0);
      flavorSum = Math.max(flavorSum, 0);
      textureSum = Math.max(textureSum, 0);
      caloriesSum = Math.max(caloriesSum, 0);

      if (validCalorie.test(caloriesSum)) {
        long prod = capacitySum * durabilitySum * flavorSum * textureSum;
        maxProd = Math.max(maxProd, prod);
      }

    } while (index.increment());

    return maxProd;
  }


  public static Input parse(List<String> lines) {
    final var capacity = new int[lines.size()];
    final var durability = new int[lines.size()];
    final var flavor = new int[lines.size()];
    final var texture = new int[lines.size()];
    final var calories = new int[lines.size()];


    final ToIntFunction<String> toValue = s -> {
      if (s.endsWith(",")) {
        return Integer.parseInt(s.substring(0, s.length() - 1));
      }
      return Integer.parseInt(s);
    };

    for (int i = 0; i < lines.size(); i++) {
      final var tokens = lines.get(i).split(" ");
      capacity[i] = toValue.applyAsInt(tokens[2]);
      durability[i] = toValue.applyAsInt(tokens[4]);
      flavor[i] = toValue.applyAsInt(tokens[6]);
      texture[i] = toValue.applyAsInt(tokens[8]);
      calories[i] = toValue.applyAsInt(tokens[10]);
    }

    return new Input(capacity, durability, flavor, texture, calories);
  }
}
