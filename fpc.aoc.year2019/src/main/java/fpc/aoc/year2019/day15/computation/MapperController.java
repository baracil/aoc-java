package fpc.aoc.year2019.day15.computation;

import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;
import lombok.NonNull;
import lombok.Value;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

public class MapperController extends AbstractController {

  private static final List<UnaryOperator<Orientation>> MODIFICATORS = List.of(
      Orientation::rotateEast,
      o -> o,
      Orientation::rotateWest,
      Orientation::opposite
  );

  private final Deque<PathElement> path = new LinkedList<>();

  private PathElement inProgress = null;

  private boolean rollback = false;

  @Override
  public void controlStarting() {
    super.controlStarting();
  }

  @Override
  protected @NonNull Optional<Orientation> getFirstOrder(@NonNull Position currentPosition) {
    final Orientation order = Orientation.N;
    inProgress = new PathElement(currentPosition, order);
    return Optional.of(order);
  }

  @Override
  protected @NonNull Optional<Orientation> evaluateNextOrder(
      @NonNull DroidState previousState,
      @NonNull Orientation sentOrder,
      @NonNull Reply replyToSentOrder,
      @NonNull DroidState updatedState) {

    final boolean droidMoved = theDroidMoved(previousState, updatedState);

    if (!rollback) {
      inProgress = inProgress.with(sentOrder);
      if (droidMoved) {
        path.addFirst(inProgress);
      }
      inProgress = inProgress.with(updatedState.position());
    }

    rollback = rollback && !droidMoved;

    final Optional<Orientation> order = findNextOrientationToMoveToUnknownPosition(updatedState);

    return order.or(this::getRollbackOrder);
  }

  private Optional<Orientation> getRollbackOrder() {
    if (path.isEmpty()) {
      return Optional.empty();
    }
    inProgress = path.removeFirst();
    rollback = true;
    return Optional.of(inProgress.orientation.opposite());
  }

  private boolean theDroidMoved(DroidState previousState, DroidState updatedState) {
    return !previousState.samePosition(updatedState);
  }

  private Optional<Orientation> findNextOrientationToMoveToUnknownPosition(@NonNull DroidState droidState) {
    for (UnaryOperator<Orientation> modificator : MODIFICATORS) {
      final Orientation orientation = modificator.apply(inProgress.orientation);
      final Position target = orientation.moveForward(inProgress.position);

      final TileType tileType = droidState.tileTypeFromMemory(target);

      if (tileType == TileType.UNKNOWN) {
        return Optional.of(orientation);
      }
    }
    return Optional.empty();
  }

  @Value
  private static class PathElement {

    @NonNull Position position;

    @NonNull Orientation orientation;

    @NonNull
    public PathElement with(@NonNull Orientation order) {
      return order == this.orientation ? this : new PathElement(position, order);
    }

    @NonNull
    public PathElement with(@NonNull Position position) {
      return position.equals(this.position) ? this : new PathElement(position, orientation);
    }
  }

}
