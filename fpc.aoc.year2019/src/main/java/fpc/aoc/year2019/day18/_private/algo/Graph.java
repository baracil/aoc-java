package fpc.aoc.year2019.day18._private.algo;

import fpc.aoc.year2019.day18._private.Key;
import fpc.aoc.year2019.day18._private.Keyring;
import fpc.aoc.year2019.day18._private.Maze;
import lombok.NonNull;

import java.util.Map;
import java.util.Optional;

public class Graph {

  @NonNull
  private final Map<Trip, Route> fastestRoutes;


  public Graph(@NonNull Maze maze) {
    this.fastestRoutes = maze.findFastedRouteBetweenKeys();
  }

  public Optional<Route> findTravelableRoute(Key from, Key to, Keyring keyring) {
    final Trip trip = new Trip(from, to);
    final Route route = fastestRoutes.get(trip);
    if (route != null && route.allIntermediaryKeysHaveBeenObtained(keyring) && route.isNotBlocked(keyring)) {
      return Optional.of(route);
    }
    return Optional.empty();
  }

}
