package fpc.aoc.year2019.day15.computation;

import fpc.aoc.common.Position;
import fpc.aoc.common.Printer;
import fpc.aoc.common.Tools;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DroidState {

    public static final Position START = Position.of(0,0);

    private final Position position;

    private final Map<Position,TileType> memory;

    public DroidState() {
        this.position = START;
        this.memory = Map.of(position,TileType.START);
    }

    @NonNull
    public DroidState updateWhenHittingWall(Position position) {
        return update(this.position, position, TileType.WALL);
    }

    @NonNull
    public DroidState updateWhenMovingOnEmptySpace(Position position) {
        return update(position,position,TileType.EMPTY);
    }

    @NonNull
    public DroidState updateWhenMovingOnOxygen(Position position) {
        return update(position,position,TileType.OXYGEN);
    }

    @NonNull
    private DroidState update(Position newPosition, Position position, TileType newTile) {
        return update(newPosition, Tools.addValue(memory,position,newTile));
    }

    @NonNull
    private DroidState update(Position newPosition, Map<Position,TileType> memory) {
        if (this.position.equals(newPosition) && this.memory.equals(memory)){
            return this;
        }
        return new DroidState(newPosition,memory);
    }


    @NonNull
    public List<String> printMemory() {
        return new Printer(this::getRepresentation, " ").print(() -> memory.keySet().stream());
    }

    @NonNull
    public Position startPosition() {
        return START;
    }

    public Position oxygenPosition() {
        return memory.entrySet()
                     .stream()
                     .filter(e -> TileType.OXYGEN.equals(e.getValue()))
                     .map(Map.Entry::getKey)
                     .findFirst()
                     .orElseThrow();
    }

    @NonNull
    public TileType tileTypeFromMemory(Position position) {
        return memory.getOrDefault(position,TileType.UNKNOWN);
    }

    private String getRepresentation(Position position) {
        final TileType tileType = memory.get(position);
        if (position.equals(this.position)) {
            if (tileType == TileType.OXYGEN) {
                return "X";
            }
            return "D";
        }
        return tileType == null? " ":tileType.representation();
    }


    public boolean samePosition(DroidState updatedState) {
        return position.equals(updatedState.position);
    }

    @NonNull
    public Maze createMazeFromMemory() {
        return Maze.create(memory);
    }
}
