package fpc.aoc.year2020.day2.structures;

import lombok.Value;

import java.util.function.Function;

@Value
public class DatabaseEntry {
  Rule rule;
  Password password;

  public static DatabaseEntry parseWithOldRule(String line) {
    return parse(line, OldRule::parse);
  }

  public static DatabaseEntry parseWithNewRule(String line) {
    return parse(line, NewRule::parse);
  }

  public static DatabaseEntry parse(String line, Function<String, ? extends Rule> ruleParser) {
    try {
      final String[] token = line.split(":", 2);
      return new DatabaseEntry(ruleParser.apply(token[0]), new Password(token[1].trim()));
    } catch (Exception e) {
      throw new RuntimeException("Could not parse database entry '" + line + "'", e);
    }
  }

  public boolean isEntryValid() {
    return rule.isPasswordValid(password);
  }

}
