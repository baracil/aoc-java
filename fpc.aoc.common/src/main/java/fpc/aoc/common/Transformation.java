package fpc.aoc.common;

import lombok.*;

import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

/**
 * Rotate then flip
 */
@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
public class Transformation {

  @NonNull Rotation rotation;

  @NonNull Flipping flipping;
  int id;

  public Transformation(@NonNull Rotation rotation, @NonNull Flipping flipping) {
    this.rotation = rotation;
    this.flipping = flipping;
    this.id = computeId(rotation, flipping);
  }


  public @NonNull IntBinaryOperator xTransformer() {
    return Holder.X_TRANSFORMERS.get(id);
  }

  public @NonNull IntBinaryOperator yTransformer() {
    return Holder.Y_TRANSFORMERS.get(id);
  }

  public @NonNull Transformation compose(@NonNull Rotation after) {
    final Rotation composed = this.rotation.compose(after);
    final Flipping flipping = switch (after) {
      case _000, _180 -> this.flipping;
      case _090, _270 -> this.flipping.rotate90();
    };
    return new Transformation(composed, flipping);
  }

  public @NonNull Transformation compose(@NonNull Flipping flipping) {
    if (flipping == this.flipping) {
      return new Transformation(rotation, Flipping.NONE);
    }
    if (flipping == Flipping.NONE) {
      return this;
    }
    if (this.flipping == Flipping.NONE) {
      return new Transformation(rotation, flipping);
    }
    return new Transformation(rotation.compose(Rotation._180), Flipping.NONE);
  }


  /**
   * id     trans (Rot)     id   trans (Rot,Flip)
   * 0      _000        4   _000,V
   * 1      _090        5   _090,V
   * 2      _180        6   _180,V
   * 3      _270        7   _270,V
   */
  private static int computeId(@NonNull Rotation rotation, @NonNull Flipping flipping) {
    final int idx = rotation.index();
    return switch (flipping) {
      case NONE -> idx;
      case VERTICAL -> idx + 4;
      case HORIZONTAL -> idx < 2 ? (idx + 6) : (idx + 2);
    };
  }

  public @NonNull Transformation compose(@NonNull Transformation transformation) {
    return this.compose(transformation.rotation).compose(transformation.flipping);
  }

  public static final Transformation IDENTITY = new Transformation(Rotation._000, Flipping.NONE);

  public static @NonNull Transformation of(@NonNull Rotation rotation, @NonNull Flipping flipping) {
    return new Transformation(rotation, flipping);
  }

  public static @NonNull Stream<Transformation> all() {
    return Holder.ALL.stream();
  }

  private static class Holder {

    public static final List<IntBinaryOperator> X_TRANSFORMERS = List.of(
      (x, y) -> x,
      (x, y) -> y,
      (x, y) -> -1 - x,
      (x, y) -> -1 - y,

      (x, y) -> -1 - x,
      (x, y) -> y,
      (x, y) -> x,
      (x, y) -> -1 - y
    );

    public static final List<IntBinaryOperator> Y_TRANSFORMERS = List.of(
      (x, y) -> y,
      (x, y) -> -1 - x,
      (x, y) -> -1 - y,
      (x, y) -> x,

      (x, y) -> y,
      (x, y) -> x,
      (x, y) -> -1 - y,
      (x, y) -> -1 - x
    );

    private static final List<Transformation> ALL = Stream.of(Rotation.values())
      .flatMap(r -> Stream.of(Flipping.values()).map(f -> Transformation.of(r, f)))
      .distinct()
      .toList();

  }
}
