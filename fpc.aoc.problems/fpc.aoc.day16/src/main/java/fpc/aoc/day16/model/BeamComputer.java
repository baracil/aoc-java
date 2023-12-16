package fpc.aoc.day16.model;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.day16.Beam;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
public class BeamComputer {

  private final ArrayOfChar input;

  public int width() {
    return input.width();
  }

  public int height() {
    return input.height();
  }

  public long compute(Beam start) {
    final var cache = new Cache();


    final List<Beam> toCheck = new LinkedList<>();

    toCheck.addLast(start);
    while (!toCheck.isEmpty()) {
      final var beams = toCheck.removeFirst();
      if (cache.put(beams)) {
        final var newBeams = beams.move(input.get(beams.position()));
        for (final Beam newBeam : newBeams) {
          if (newBeam.isInside(input.width(),input.height())) {
            toCheck.add(newBeam);
          }
        }
      }
    }

    return cache.size();
  }

}
