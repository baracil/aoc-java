package fpc.aoc.year2019.day13._private;

import fpc.aoc.common.Position;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameOutput {

    @NonNull
    private final OutputListener outputListener;

    private int count = 0;

    private int x;

    private int y;

    public void write(String value) {
        switch (count) {
            case 0 :
                x = Integer.parseInt(value);
                break;
            case 1 :
                y = Integer.parseInt(value);
                break;
            case 2 :
                if (x==-1 && y==0) {
                    outputListener.onScore(value);
                } else {
                    outputListener.onTile(new Tile(Position.of(x,y),TileType.decode(value)));
                }
                break;
        }
        count = (count+1)%3;
    }
}
