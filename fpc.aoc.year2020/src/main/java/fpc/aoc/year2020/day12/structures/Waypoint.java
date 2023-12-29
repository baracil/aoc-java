package fpc.aoc.year2020.day12.structures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Waypoint {
    private int x;
    private int y;

    public void moveBy(int dx, int dy) {
        this.x +=dx;
        this.y +=dy;
    }
}
