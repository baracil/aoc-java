package fpc.aoc.year2019.day11.computation;

import fpc.aoc.common.Position;
import fpc.aoc.common.Printer;
import lombok.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hull {

    private final Set<Position> panels = new HashSet<>();

    public void clear() {
        panels.clear();
    }

    @NonNull
    public Color getPanelColor(@NonNull Position position) {
        return panels.contains(position) ? Color.WHITE : Color.BLACK;
    }

    public void paint(@NonNull Position position, @NonNull Color color) {
        if (color == Color.BLACK) {
            panels.remove(position);
        }
        else {
            panels.add(position);
        }
    }

    @NonNull
    public List<String> dump() {
        Printer print = new Printer(p -> panels.contains(p) ? "█" : " ", " ");

        return print.print(panels::stream);
    }

}
