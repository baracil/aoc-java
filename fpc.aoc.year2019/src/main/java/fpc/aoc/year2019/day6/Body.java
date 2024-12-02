package fpc.aoc.year2019.day6;

import fpc.aoc.common.AOCException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class Body {

    @NonNull
    @Getter
    private final String id;

    private Body parent;

    @NonNull
    private final List<Body> moons = new ArrayList<>();

    public boolean isRoot() {
        return id.equals("COM");
    }

    public void addMoon(Body moon) {
        if (moon.parent != null) {
            throw new AOCException("Moon '" + moon.id + "' is already orbiting '" + moon.parent.id + "'");
        }
        moon.parent = this;
        moons.add(moon);
    }

    public void forEachMoon(Consumer<Body> consumer) {
        moons.forEach(consumer);
    }

    public Body parent() {
        return parent;
    }
}
