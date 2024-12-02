package fpc.aoc.year2020.day19.structures;

import lombok.Value;

@Value
public class IndexedString {

  public static IndexedString initial(String reference) {
    return new IndexedString(reference, 0);
  }

  String reference;

  int offset;

  public char charAt(int idx) {
    return reference.charAt(idx + offset);
  }

  public IndexedString addToOffset(int value) {
    return new IndexedString(reference, value + offset);
  }

  public boolean isEmpty() {
    return offset >= reference.length();
  }

  @Override
  public String toString() {
    return "IndexedString{" + reference.substring(offset) + "}";
  }
}
