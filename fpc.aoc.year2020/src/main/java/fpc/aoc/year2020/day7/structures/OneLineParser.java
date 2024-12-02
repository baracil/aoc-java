package fpc.aoc.year2020.day7.structures;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Pair;
import fpc.aoc.common.Tools;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class OneLineParser {

  public static OneLineParsing parse(String line) {
    try {
      return new OneLineParser(line).parse();
    } catch (Exception e) {
      throw new AOCException("Could not parse line '" + line + "'", e);
    }
  }

  private static final Pattern ONE_RULE_ITEM = Pattern.compile("([0-9]+) ([a-z]+ [a-z]+) bags?");

  public static final String BAGS_CONTAIN = "bags contain";


  private final String line;

  private String firstPart = null;
  private String secondPart = null;

  private String[] ruleItems = null;

  private Map<String, Integer> contents;

  private OneLineParsing parse() {
    this.splitLine();
    this.removeDotFromSecondPart();
    this.splitSecondPartOnComa();
    this.parseAllRuleItems();
    return new OneLineParsing(firstPart, contents);
  }

  private void splitLine() {
    final int idx = line.indexOf(BAGS_CONTAIN);
    if (idx < 0) {
      throw new AOCException("Cannot find '" + BAGS_CONTAIN + "' in line");
    }
    firstPart = line.substring(0, idx).trim();
    secondPart = line.substring(idx + BAGS_CONTAIN.length()).trim();
  }

  private void removeDotFromSecondPart() {
    assert secondPart != null;
    if (secondPart.endsWith(".")) {
      secondPart = secondPart.substring(0, secondPart.length() - 1);
    }
  }

  private void splitSecondPartOnComa() {
    this.ruleItems = secondPart.split(",");
  }

  private void parseAllRuleItems() {
    this.contents = Arrays.stream(ruleItems)
        .map(String::trim)
        .map(this::parseOneRuleItem)
        .filter(Objects::nonNull)
        .collect(Tools.pairsToMap());
  }

  private Pair<String, Integer> parseOneRuleItem(String item) {
    if (item.equals("no other bags")) {
      return null;
    }
    final var matcher = ONE_RULE_ITEM.matcher(item);
    if (!matcher.matches()) {
      throw new AOCException("Could not parse item '" + item + "'");
    }
    final var number = Integer.parseInt(matcher.group(1));
    final var colorName = matcher.group(2);
    return Pair.of(colorName, number);
  }


}
