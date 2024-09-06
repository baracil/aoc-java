package fpc.aoc.year2019.day6;

import lombok.NonNull;

public interface OrbitWalker {

    void enter(@NonNull Body body);

    void leave(@NonNull Body body);
}
