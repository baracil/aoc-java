package fpc.aoc.year2022.day22;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Map;

@RequiredArgsConstructor
public class Navigation {

    @Getter
    private final Position start;
    private final Map<Position, Pos> pos;

    public Move next(Position position, Orientation orientation) {
        final var pos = this.pos.get(position);
        if (pos == null) {
            throw new AOCException("Invalid position "+position);
        }
        return pos.next(orientation);
    }



    @Value
    public static class Pos {
        Position position;
        Map<Orientation,Move> neighbours;

        public Move next(Orientation orientation)
        {
            final var result= neighbours.get(orientation);
            if (result == null) {
                throw new AOCException("Not next for "+position+" "+orientation);
            }
            return result;
        }
    }
}
