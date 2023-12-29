package fpc.aoc.year2023.day19.model;

import java.util.Optional;

public record MultiScrap(Range x, Range m, Range a, Range s) {

  public long nbScraps() {
    return x.length() * m.length() * a.length() * s.length();
  }

  public Optional<MultiScrap> withX(Range x) {
    if (x.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(new MultiScrap(x, m, a, s));
  }

  public Optional<MultiScrap> withM(Range m) {
    if (m.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(new MultiScrap(x, m, a, s));
  }

  public Optional<MultiScrap> withA(Range a) {
    if (a.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(new MultiScrap(x, m, a, s));
  }

  public Optional<MultiScrap> withS(Range s) {
    if (s.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(new MultiScrap(x, m, a, s));
  }

}
