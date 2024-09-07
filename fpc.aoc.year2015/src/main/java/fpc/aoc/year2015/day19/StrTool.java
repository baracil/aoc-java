package fpc.aoc.year2015.day19;

public class StrTool {

  public static String replace(String line, String source, int idx, String replacement) {
    final var idxAfter = idx+source.length();
    final var prefix = line.substring(0,idx);
    final var suffix = idxAfter>=line.length()?"":line.substring(idxAfter);

    return prefix+replacement+suffix;
  }
}
