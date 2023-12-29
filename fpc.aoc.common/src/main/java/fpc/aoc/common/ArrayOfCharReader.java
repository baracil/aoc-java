package fpc.aoc.common;

public interface ArrayOfCharReader {

  default void copyTo(char[] target, int offset, int lineStride, int srcOffsetX, int srcOffsetY, int srcLengthX, int srcLengthY) {
    for (int y = 0, t = offset; y < srcLengthY; y++, t += (lineStride - srcLengthX)) {
      for (int x = 0; x < srcLengthX; x++, t++) {
        target[t] = get(srcOffsetX + x, srcOffsetY + y);
      }
    }
  }

  char get(int x, int y);
}
