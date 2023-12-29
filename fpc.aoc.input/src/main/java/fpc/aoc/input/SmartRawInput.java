package fpc.aoc.input;

import fpc.aoc.api.Day;
import fpc.aoc.api.RawInput;
import fpc.aoc.api.SolverId;
import fpc.aoc.api.Year;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SmartRawInput implements RawInput {

  private final Year year;
  private final Day day;

  public SmartRawInput(SolverId solverId) {
    this.year = solverId.year();
    this.day = solverId.day();
  }

  @Override
  public @NonNull List<String> read() {
    return getRawInput().read();
  }

  private RawInput getRawInput() {
    final var sessionId = System.getProperty("oac-session-id");
    if (sessionId == null) {
      return new ResourceFile(year, day);
    }

    return new AOCWebsite(year, day, sessionId);
  }
}
