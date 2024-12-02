package fpc.aoc.input;

import fpc.aoc.api.Day;
import fpc.aoc.api.RawInput;
import fpc.aoc.api.SolverId;
import fpc.aoc.api.Year;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
public class ResourceFile implements RawInput {

  private final Year year;
  private final Day day;


  public ResourceFile(SolverId solverId) {
    this(solverId.year(), solverId.day());
  }

  @Override
  public List<String> read() {
    final var moduleName = "fpc.aoc.year%04d".formatted(year.numericalValue());
    final var resourceName = "input_day_%02d.txt".formatted(day.numericalValue());

    final var module = ModuleLayer.boot()
        .findModule(moduleName)
        .orElseThrow();


    try (var bfr = new BufferedReader(new InputStreamReader(module.getResourceAsStream(resourceName), StandardCharsets.UTF_8))) {
      return bfr.lines().toList();
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}
