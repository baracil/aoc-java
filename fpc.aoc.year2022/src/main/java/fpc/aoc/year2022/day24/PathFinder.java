package fpc.aoc.year2022.day24;

import fpc.aoc.common.Position;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.function.Predicate.not;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PathFinder {

  public static Path findPathPart1(Map map) {
    return new PathFinder(map).findPathPart1();
  }

  public static Path findPathPart2(Map map) {
    return new PathFinder(map).findPathPart2();
  }

  private final Map map;

  private Path findPathPart1() {
    final var start = new Path(Position.of(1,0),0,null);
    return findPath(start, map::isExit);
  }

  private Path findPathPart2() {
    final var start = new Path(Position.of(1,0),0,null);
    final var p1 = findPath(start, map::isExit);
    final var p2 = findPath(p1,map::isStart);
    return findPath(p2,map::isExit);
  }

  private Path findPath(Path start, Predicate<Position> doneTest) {

    final Deque<Path> toProcess = new LinkedList<>();
    final Set<Path> visited = new HashSet<>();

    toProcess.add(start);
    visited.add(start);

    while(true) {
      final var p = toProcess.removeFirst();
      if (doneTest.test(p.position())) {
        return p;
      }
      p.next()
          .filter(not(visited::contains))
          .filter(map::canMoveTo)
          .forEach(path -> {
            visited.add(path);
            toProcess.addLast(path);
          });
    }
  }

}
