package fpc.aoc.year2020.day2.structures;

import lombok.NonNull;
import lombok.Value;

import java.util.function.Function;

@Value
public class DatabaseEntry {
  @NonNull Rule rule;
  @NonNull Password password;

  public static @NonNull DatabaseEntry parseWithOldRule(@NonNull String line) {
    return parse(line, OldRule::parse);
  }

  public static @NonNull DatabaseEntry parseWithNewRule(@NonNull String line) {
    return parse(line, NewRule::parse);
  }

  public static @NonNull DatabaseEntry parse(@NonNull String line, Function<String, ? extends Rule> ruleParser) {
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
