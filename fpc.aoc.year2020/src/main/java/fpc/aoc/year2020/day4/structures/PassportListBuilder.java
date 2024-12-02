package fpc.aoc.year2020.day4.structures;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PassportListBuilder {

  public static List<Passport> build(List<String> input) {
    return new PassportListBuilder(input).build();
  }

  private final List<String> input;

  private final List<Passport> listBuilder = new ArrayList<>();

  private PassportBuilder passportBuilder = null;

  public List<Passport> build() {
    for (String line : input) {
      if (line.isBlank()) {
        this.handleBlankLine();
      } else {
        this.handleNotBlankLine(line);
      }
    }
    this.appendBuilderInProgressToList();

    return listBuilder;
  }

  private void handleBlankLine() {
    this.appendBuilderInProgressToList();
  }

  private void handleNotBlankLine(String line) {
    this.createPassportBuilderIfNecessary();
    this.passportBuilder.addLine(line);
  }

  private void createPassportBuilderIfNecessary() {
    if (passportBuilder == null) {
      passportBuilder = Passport.builder();
    }
  }

  private void appendBuilderInProgressToList() {
    if (passportBuilder != null) {
      listBuilder.add(passportBuilder.build());
      passportBuilder = null;
    }
  }


}
