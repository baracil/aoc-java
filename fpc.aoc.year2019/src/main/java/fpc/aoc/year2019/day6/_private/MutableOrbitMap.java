package fpc.aoc.year2019.day6._private;

import fpc.aoc.year2019.day6.*;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MutableOrbitMap implements OrbitMap {

  private final Body root;

  @NonNull
  private final Map<String, Body> bodyById = new HashMap<>();

  public MutableOrbitMap() {
    this.root = new Body("COM");
    this.bodyById.put(root.id(), root);
  }

  @Override
  public @NonNull OrbitPath pathFromRoot(@NonNull String bodyId) {
    Body body = bodyById.get(bodyId);
    final var bodyIds = new ArrayList<String>();

    do {
      bodyIds.add(body.id());
      body = body.parent();
    } while (body != null);
    Collections.reverse(bodyIds);
    return new OrbitPath(bodyIds);
  }

  @Override
  public int distanceFromRoot(@NonNull String bodyId) {
    Body body = bodyById.get(bodyId);
    int distance = 0;
    while (!body.isRoot()) {
      distance++;
      body = body.parent();
    }
    return distance;
  }

  public void addRelationShip(@NonNull Relationship relationship) {
    final Body planet = getOrCreate(relationship.idOfPlanet());
    final Body moon = getOrCreate(relationship.idOfMoon());
    planet.addMoon(moon);
  }

  @NonNull
  private Body getOrCreate(@NonNull String id) {
    return bodyById.computeIfAbsent(id, Body::new);
  }

  @Override
  public void depthFirstWalk(@NonNull OrbitWalker walker) {
    depthFirst(root, walker);
  }

  private static void depthFirst(@NonNull Body current, @NonNull OrbitWalker walker) {
    walker.enter(current);
    try {
      current.forEachMoon(moon -> depthFirst(moon, walker));
    } finally {
      walker.leave(current);
    }
  }
}
