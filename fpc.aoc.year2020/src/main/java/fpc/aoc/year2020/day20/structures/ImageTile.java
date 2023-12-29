package fpc.aoc.year2020.day20.structures;


import fpc.aoc.common.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageTile implements ArrayOfCharReader {

  @Getter
  private final int id;

  private final @NonNull ArrayOfChar arrayOfChar;

  private final @NonNull LazyString upperBorder;
  private final @NonNull LazyString rightBorder;
  private final @NonNull LazyString lowerBorder;
  private final @NonNull LazyString leftBorder;
  private final @NonNull LazyString reversedRightBorder;
  private final @NonNull LazyString reversedLowerBorder;

  public ImageTile(int id, @NonNull ArrayOfChar arrayOfChar) {
    this.id = id;
    this.arrayOfChar = arrayOfChar;
    this.upperBorder = LazyString.of(arrayOfChar::upperBorder);
    this.rightBorder = LazyString.of(arrayOfChar::rightBorder);
    this.lowerBorder = LazyString.of(arrayOfChar::lowerBorder);
    this.leftBorder = LazyString.of(arrayOfChar::leftBorder);
    this.reversedRightBorder = LazyString.of(() -> Tools.reverse(rightBorder.toString()));
    this.reversedLowerBorder = LazyString.of(() -> Tools.reverse(lowerBorder.toString()));
  }

  public @NonNull ImageTile transform(@NonNull Transformation transformation) {
    final ArrayOfChar transformed = arrayOfChar.transform(transformation);
    if (transformed == arrayOfChar) {
      return this;
    }
    return new ImageTile(id, transformed);
  }

  @Override
  public char get(int x, int y) {
    return arrayOfChar.get(x, y);
  }

  public @NonNull String upperBorder() {
    return upperBorder.toString();
  }

  public @NonNull String rightBorder() {
    return rightBorder.toString();
  }

  public @NonNull String lowerBorder() {
    return lowerBorder.toString();
  }

  public @NonNull String leftBorder() {
    return leftBorder.toString();
  }

  public int width() {
    return arrayOfChar.width();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ImageTile imageTile = (ImageTile) o;
    return id == imageTile.id && Objects.equals(arrayOfChar.transformation(), imageTile.arrayOfChar.transformation());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, arrayOfChar.transformation());
  }

  public String reversedLowerBorder() {
    return reversedLowerBorder.toString();
  }

  public String reversedRightBorder() {
    return reversedRightBorder.toString();
  }
}
