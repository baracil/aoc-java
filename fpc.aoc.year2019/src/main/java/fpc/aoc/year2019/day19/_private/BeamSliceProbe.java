package fpc.aoc.year2019.day19._private;

import fpc.aoc.common.Position;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.io.ProgramIO;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Bastien Aracil
 **/
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BeamSliceProbe {

  @NonNull
  public static BeamSlice probe(Program program, Position start) {
    return new BeamSliceProbe(program, start).probe();
  }

  @NonNull
  private final Program program;

  private final Position start;

  private Position current;

  private BeamSlice probe() {
    this.current = start;
    Position first = null;
    int length = 0;

    do {
      final boolean pullFelt = probeSinglePosition();
      if (pullFelt) {
        length++;
        if (first == null) {
          first = current;
        }
      } else if (first != null) {
        return new BeamSlice(first, length);
      }
      current = current.right();
    } while (first != null || current.x() - start.x() < 5);
    return new BeamSlice(start, 0);
  }

  private boolean probeSinglePosition() {
    return program.launchAndWait(
        "probing",
        ProgramIO.fromList(Position::putXYInListOfString, current).ignoreOutput()
    ).getLastOutput().equals("1");

  }

}
