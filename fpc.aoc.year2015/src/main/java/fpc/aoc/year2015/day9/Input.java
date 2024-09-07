package fpc.aoc.year2015.day9;

import lombok.Value;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Value
public class Input {

  Map<String,List<Path>> pathByStart;

  public static Input create(List<Path> paths) {
    return new Input(Stream.concat(paths.stream(),paths.stream().map(Path::invert)).collect(Collectors.groupingBy(Path::start)));
  }

  public Collection<String> cities() {
    return pathByStart.keySet();
  }

  public int size() {
    return pathByStart.size();
  }

  public List<Path> findConnected(String point) {
    return pathByStart.getOrDefault(point,List.of());
  }
}
