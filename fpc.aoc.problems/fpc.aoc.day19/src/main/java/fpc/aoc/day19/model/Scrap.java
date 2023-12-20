package fpc.aoc.day19.model;

import fpc.aoc.common.AOCException;

import java.util.regex.Pattern;

public record Scrap(int x, int m, int a, int s) {


  public int rating() {
    return x+m+a+s;
  }


  public static final Pattern PATTERN = Pattern.compile("\\{x=(?<x>[0-9]+),m=(?<m>[0-9]+),a=(?<a>[0-9]+),s=(?<s>[0-9]+)}");

  public static Scrap parse(String line) {
    final var matcher = PATTERN.matcher(line);
    if (!matcher.matches()) {
      throw new AOCException("Cannot match '"+line+"'");
    }
    final var x = Integer.parseInt(matcher.group("x"));
    final var m = Integer.parseInt(matcher.group("m"));
    final var a = Integer.parseInt(matcher.group("a"));
    final var s = Integer.parseInt(matcher.group("s"));

    return new Scrap(x,m,a,s);
  }
}
