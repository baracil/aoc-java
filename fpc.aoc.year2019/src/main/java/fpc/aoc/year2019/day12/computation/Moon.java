package fpc.aoc.year2019.day12.computation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Moon {

    public static Moon create(Vector position) {
        return new Moon(position,Vector.NIL);
    }

    private final Vector position;

    private final Vector velocity;

    public int totalEnergy() {
        return position.energy()*velocity.energy();
    }

    @NonNull
    public Moon update(Vector force) {
        final Vector newVelocity = velocity.add(force);
        final Vector newPosition = position.add(newVelocity);
        return new Moon(newPosition,newVelocity);
    }


    public static Vector forceBetween(Moon moon1, Moon moon2) {
        return moon1.position.forceBetween(moon2.position);
    }

    @Override
    public String toString() {
        return String.format("pos=%s, vel=%s",position,velocity);
    }
}
