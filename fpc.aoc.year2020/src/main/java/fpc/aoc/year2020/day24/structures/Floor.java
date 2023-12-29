package fpc.aoc.year2020.day24.structures;


import java.util.HashSet;
import java.util.Set;

public class Floor {

    private final Set<HexaPoint> blackTiles;

    public Floor(Set<HexaPoint> initialBlackTiles) {
        this.blackTiles = new HashSet<>(initialBlackTiles);
    }
}
