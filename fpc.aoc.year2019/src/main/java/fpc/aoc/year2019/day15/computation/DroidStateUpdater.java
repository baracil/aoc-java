package fpc.aoc.year2019.day15.computation;

import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;
import fpc.aoc.robot.Order;
import fpc.aoc.robot.StateUpdater;
import lombok.NonNull;

public class DroidStateUpdater implements StateUpdater<Orientation,DroidState> {

    @NonNull
    @Override
    public DroidState createInitialState() {
        return new DroidState();
    }

    @NonNull
    @Override
    public DroidState updateStateOnReply(
            DroidState current,
            Order<Orientation> lastSendOrder,
            String replyAsString) {
        final Orientation orientation = lastSendOrder.source().orElse(null);

        if (orientation != null) {
            final Reply reply = Reply.decode(replyAsString);
            final Position targetedPosition = orientation.moveForward(current.position());
            return reply.update(current,targetedPosition);
        }

        return current;
    }
}
