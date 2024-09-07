package fpc.aoc.year2019.day21._private;

import fpc.aoc.common.EnumHelper;
import lombok.Getter;
import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public enum SensorRegistry {
  A(0, "A"),
  B(1, "B"),
  C(2, "C"),
  D(3, "D"),
  E(4, "E"),
  F(5, "F"),
  G(6, "G"),
  H(7, "H"),
  I(8, "I"),
  ;

  @Getter
  private final int level;

  private final int mask;

  @NonNull
  private final String trueForm;

  @NonNull
  private final String falseForm;

  SensorRegistry(int level, @NonNull String trueForm) {
    this.level = level;
    this.mask = 1 << level;
    this.trueForm = trueForm;
    this.falseForm = trueForm + "\u0304";
  }

  public boolean isSet(int value) {
    return (mask & value) != 0;
  }

  public boolean isNotSet(int value) {
    return (mask & value) == 0;
  }

  public static ParameterNames parameterNames() {
    return new ParameterNames() {
      @Override
      public @NonNull String trueForm(int index) {
        return getRegistry(index).trueForm;
      }

      @Override
      public @NonNull String falseForm(int index) {
        return getRegistry(index).falseForm;
      }
    };
  }

  @NonNull
  public static SensorRegistry getRegistry(int level) {
    return Holder.HELPER.get(level);
  }

  private static class Holder {

    private final static EnumHelper<Integer, SensorRegistry> HELPER = EnumHelper.create(SensorRegistry.class,
        SensorRegistry::level);
  }
}
