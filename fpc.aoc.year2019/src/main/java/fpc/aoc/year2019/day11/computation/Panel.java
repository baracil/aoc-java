package fpc.aoc.year2019.day11.computation;

import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Panel {

    @NonNull
    private final Position position;

    @NonNull
    private Color color = Color.BLACK;

    public void paint(@NonNull Color color) {
        this.color = color;
    }
}
