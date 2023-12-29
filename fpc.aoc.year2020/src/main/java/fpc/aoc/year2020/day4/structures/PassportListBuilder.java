package fpc.aoc.year2020.day4.structures;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PassportListBuilder {

  public static @NonNull List<Passport> build(@NonNull List<String> input) {
    return new PassportListBuilder(input).build();
  }

  private final @NonNull List<String> input;

  private final @NonNull List<Passport> listBuilder = new ArrayList<>();

  private PassportBuilder passportBuilder = null;

  public @NonNull List<Passport> build() {
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

  private void handleNotBlankLine(@NonNull String line) {
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
