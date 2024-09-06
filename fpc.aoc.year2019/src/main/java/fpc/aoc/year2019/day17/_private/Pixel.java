package fpc.aoc.year2019.day17._private;

import fpc.aoc.common.EnumHelper;
import fpc.aoc.common.Orientation;
import lombok.Getter;
import lombok.NonNull;

public enum Pixel {
  SPACE(".", false),
  SCAFFOLD("#", true),
  ROBOT_UP("^", Orientation.N),
  ROBOT_DOWN("v", Orientation.S),
  ROBOT_LEFT("<", Orientation.E),
  ROBOT_RIGHT(">", Orientation.W),
  ;

  @Getter
  private final String representation;

  private final Orientation orientation;

  Pixel(@NonNull String representation, @NonNull Orientation orientation) {
    this.representation = representation;
    this.scaffold = true;
    this.orientation = orientation;
  }

  Pixel(String representation, boolean scaffold) {
    this.representation = representation;
    this.scaffold = scaffold;
    this.orientation = null;
  }

  @Getter private final boolean scaffold;

  public boolean isRobot() {
    return orientation != null;
  }

  @NonNull
  public Orientation orientation() {
    return orientation == null ? Orientation.S : orientation;
  }

  @NonNull
  public static Pixel decode(@NonNull String pixel) {
    return Holder.HELPER.get(pixel);
  }

  private static class Holder {
    private static final EnumHelper<String, Pixel> HELPER = EnumHelper.create(Pixel.class, p -> String.valueOf((int) p.representation.charAt(0)));
  }
}
