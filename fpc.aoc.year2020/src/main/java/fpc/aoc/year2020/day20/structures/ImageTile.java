package fpc.aoc.year2020.day20.structures;


import fpc.aoc.common.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageTile implements ArrayOfCharReader {

  @Getter
  private final int id;

  private final ArrayOfChar arrayOfChar;

  private final LazyString upperBorder;
  private final LazyString rightBorder;
  private final LazyString lowerBorder;
  private final LazyString leftBorder;
  private final LazyString reversedRightBorder;
  private final LazyString reversedLowerBorder;

  public ImageTile(int id, ArrayOfChar arrayOfChar) {
    this.id = id;
    this.arrayOfChar = arrayOfChar;
    this.upperBorder = LazyString.of(arrayOfChar::upperBorder);
    this.rightBorder = LazyString.of(arrayOfChar::rightBorder);
    this.lowerBorder = LazyString.of(arrayOfChar::lowerBorder);
    this.leftBorder = LazyString.of(arrayOfChar::leftBorder);
    this.reversedRightBorder = LazyString.of(() -> Tools.reverse(rightBorder.toString()));
    this.reversedLowerBorder = LazyString.of(() -> Tools.reverse(lowerBorder.toString()));
  }

  public ImageTile transform(Transformation transformation) {
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

  public String upperBorder() {
    return upperBorder.toString();
  }

  public String rightBorder() {
    return rightBorder.toString();
  }

  public String lowerBorder() {
    return lowerBorder.toString();
  }

  public String leftBorder() {
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
