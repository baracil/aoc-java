package fpc.aoc.year2019.day13._private;

import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.NonNull;

public class GameIO implements OutputListener {

    private Position currentBallPosition;

    private Position paddle;

    @Getter
    private String score = "0";

    private final GameOutput output = new GameOutput(this);

    @NonNull
    public String read() {
        if (currentBallPosition == null) {
            return "0";
        }
        int dt = currentBallPosition.x()-paddle.x();
        return dt==0?"0":(dt<0?"-1":"1");
    }

    public void write(String value) {
        output.write(value);
    }

    @Override
    public void onTile(Tile tile) {
        switch (tile.type()) {
            case BALL:
                currentBallPosition = tile.position();
                break;
            case HORIZONTAL_PADDLE:
                paddle = tile.position();
                break;
        }
    }

    @Override
    public void onScore(String score) {
        this.score = score;
    }
}
