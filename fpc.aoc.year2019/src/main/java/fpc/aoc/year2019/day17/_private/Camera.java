package fpc.aoc.year2019.day17._private;

import fpc.aoc.computer.Program;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Camera {

  @NonNull
  private final Program program;

  @NonNull
  public Picture takePicture() {
    final var execution = program.launchAndWait("Camera");

    return execution.outputs().stream().collect(Picture.collector());
  }

}
