package fpc.aoc.year2021.day17.struct;

import lombok.NonNull;
import lombok.Value;

@Value
public class Probe {
    Vec position;
    Vec velocity;

    public @NonNull Probe afterOnTick() {
        return new Probe(position.add(velocity), velocity.updatedVelocity());
    }

    public boolean isInside(@NonNull Target target) {
        return target.xmin() <= position.x()
                && target.xmax() >= position().x()
                && target.ymin() <= position().y()
                && target.ymax() >= position().y();
    }

    public boolean missed(@NonNull Target target) {
        return target.xmax() < position.x() || target.ymin() > position.y() || (target.xmin() > position.x() && velocity.x() == 0);
    }

}
