package fpc.aoc.year2022.day24;

import fpc.aoc.common.Position;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.util.stream.Stream;

@Value
@ToString(exclude = "previous")
@EqualsAndHashCode(of = {"position", "turn"})
public class Path {
  Position position;
  int turn;
  Path previous;


  public Stream<Path> next() {
    return Stream.of(
        new Path(position.translate(1, 0), turn + 1, this),
        new Path(position.translate(0, 1), turn + 1, this),
        new Path(position.translate(-1, 0), turn + 1, this),
        new Path(position.translate(0, -1), turn + 1, this),
        new Path(position, turn + 1, this)
    );
  }
}
