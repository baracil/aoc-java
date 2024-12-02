package fpc.aoc.year2019.day7;

import lombok.NonNull;

public interface Circuit {

    @NonNull
    String launch(Phase phase);

}
