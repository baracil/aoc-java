package fpc.aoc.year2019.day20._private;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Bastien Aracil
 **/
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PortalFinder {

  @NonNull
  public static Map<String, List<Portal>> find(@NonNull ArrayOfChar data) {
    return new PortalFinder(data).find();
  }

  @NonNull
  private final ArrayOfChar data;

  @NonNull
  public Map<String, List<Portal>> find() {
    return data.positionStream()
        .map(this::createPortal)
        .flatMap(Optional::stream)
        .collect(
            Collectors.collectingAndThen(
                Collectors.groupingBy(Portal::name, Collectors.toList()),
                Map::copyOf
            )
        );
  }

  private Optional<Portal> createPortal(Position position) {
    return PortalSearchParty.valueStream()
        .map(searchParty -> searchParty.checkForPortal(data, position))
        .flatMap(Optional::stream)
        .findAny();
  }

}
