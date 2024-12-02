package fpc.aoc.year2019.day15.computation;

import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;
import fpc.aoc.robot.Controller;
import fpc.aoc.robot.Order;
import fpc.aoc.robot.OrderProducer;
import lombok.NonNull;

import java.util.Optional;

public abstract class AbstractController implements Controller<Orientation, DroidState> {

  private DroidState previousState = null;

  private Orientation lastSentOrder = null;

  private Reply lastReply = null;

  private final OrderProducer<Orientation> orderProducer = Order.create(AbstractController::getCode);

  @Override
  public Order<Orientation> evaluateNextOrders(DroidState currentState) {
    final Optional<Orientation> movement;

    if (lastSentOrder == null) {
      movement = getFirstOrder(currentState.position());
    } else {
      movement = evaluateNextOrder(previousState, lastSentOrder, lastReply, currentState);
    }

    lastSentOrder = movement.orElse(null);

    return movement.map(orderProducer::sendData)
        .orElseGet(orderProducer::stop);
  }

  @Override
  public void updateOnReply(String reply, DroidState previousState, DroidState currentState) {
    this.lastReply = Reply.decode(reply);
    this.previousState = previousState;
  }

  @NonNull
  protected abstract Optional<Orientation> getFirstOrder(Position currentPosition);

  @NonNull
  protected abstract Optional<Orientation> evaluateNextOrder(
      DroidState previousState,
      Orientation sentOrder,
      Reply replyToSentOrder,
      DroidState updatedState);

  private static String getCode(Orientation orientation) {
    return switch (orientation) {
      case N -> "1";
      case S -> "2";
      case W -> "3";
      case E -> "4";
    };
  }
}
