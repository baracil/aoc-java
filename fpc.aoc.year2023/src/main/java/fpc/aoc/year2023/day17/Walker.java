package fpc.aoc.year2023.day17;

import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Walker {
  private long idGenerator = 0;
  private final Map<Key, Value> seenByKey = new HashMap<>();
  private final Map<Long, Step> buffer = new HashMap<>();
  private final List<Long> toDo = new LinkedList<>();


  public boolean hasToDo() {
    return !toDo.isEmpty();
  }

  public Step next() {
    final var id = toDo.removeFirst();
    return buffer.remove(id);
  }


  public void handleNew(Step step) {
    final var key = Key.fromStep(step);

    final var existing = seenByKey.get(key);

    if (existing == null) {
      final var id = ++idGenerator;
      buffer.put(id, step);
      seenByKey.put(key, new Value(id, step));
      toDo.addLast(id);

    } else if (existing.heatLoss() > step.totalHeatLoss()) {
      if (null == buffer.put(existing.id, step)) {
        this.toDo.addFirst(existing.id);
      }
      seenByKey.put(key, existing.withNewStep(step));
    }
  }


  private record Value(long id, Step step) {
    public int heatLoss() {
      return step.totalHeatLoss();
    }

    public Value withNewStep(Step step) {
      return new Value(id, step);
    }
  }

  private record Key(Position position, Orientation orientation, int nb) {
    public static Key fromStep(Step step) {
      return new Key(step.position(),step.orientation(),step.nb());
    }
  }
}
