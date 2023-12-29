package fpc.aoc.year2023.day19.model;

import fpc.aoc.common.AOCException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

@RequiredArgsConstructor
public class Dispatcher {

  @Getter
  private final ScrapPredicate test;
  @Getter
  private final String workflowName;

  public String check(Scrap scrap) {
    if (test.test(scrap)) {
      return workflowName;
    }
    return null;
  }

  public Split<MultiScrap> check(MultiScrap scrap) {
    return test.test(scrap);
  }


  public static final Pattern PATTERN = Pattern.compile("(?<prop>[xmas])(?<op>[<>])(?<value>[0-9]+):(?<wkf>[a-zAR]+)");

  public static Dispatcher parse(String token) {
    final var match = PATTERN.matcher(token);
    if (!match.matches()) {
      throw new AOCException("Cannot parse '" + token + "' to a Dispatcher");
    }
    final var prop = match.group("prop");
    final var op = match.group("op");
    final var value = Integer.parseInt(match.group("value"));
    final var wkf = match.group("wkf");

    final var getter = switch (prop) {
      case "x" -> ScrapProp.X;
      case "m" -> ScrapProp.M;
      case "a" -> ScrapProp.A;
      case "s" -> ScrapProp.S;
      default -> throw new AOCException("Cannot parse '" + token + "'");
    };


    final var predicate = op.equals("<") ? new ScrapPredicate.LowerTest(getter, value) : new ScrapPredicate.GreaterTest(getter, value);

    return new Dispatcher(predicate, wkf);
  }


}
