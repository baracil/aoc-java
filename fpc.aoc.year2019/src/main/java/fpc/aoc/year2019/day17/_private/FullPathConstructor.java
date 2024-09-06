package fpc.aoc.year2019.day17._private;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Command;
import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FullPathConstructor {

    @NonNull
    public static Path constructFrom(@NonNull Picture picture) {
        return new FullPathConstructor(picture).constructFrom();
    }

    private final Picture picture;

    private Position position;

    private Orientation orientation;

    private Set<Position> visitedPositions = new HashSet<>();

    private int initialDisplacement = 0;

    private List<PathElement> elements = new ArrayList<>();

    private boolean cannotMoveFurther = false;


    @NonNull
    private Path constructFrom() {
        this.initializeStartingPointToRobotPosition();
        do {
            extractOnePathElement();
        } while (!cannotMoveFurther);
        return new Path(initialDisplacement, List.copyOf(elements));
    }

    private void extractOnePathElement() {
        final Position newPosition = picture.scaffoldNextTo(position)
               .filter(this::isNotAlreadyVisited)
               .findFirst().orElse(null);

        if (newPosition == null) {
            cannotMoveFurther = true;
            return;
        }

        final Orientation newOrientation = position.orientationOf(newPosition);
        final Command command = orientation.commandToSwitchTo(newOrientation);

        orientation = newOrientation;
        int displacement= moveForwardAsMuchAsPossible();

        elements.add(new PathElement(command,displacement));
    }

    private int moveForwardAsMuchAsPossible() {
        int movements = 0;
        do {
            final Position forward = orientation.moveForward(position);
            if (picture.isScaffoldPresentAt(forward)) {
                position = forward;
                visitedPositions.add(position);
                movements++;
            } else {
                break;
            }
        } while (true);
        return movements;

    }

    private boolean isNotAlreadyVisited(Position position) {
        return !visitedPositions.contains(position);
    }

    private void initializeStartingPointToRobotPosition() {
        position = picture.getVacuumPosition().orElseThrow(() -> new AOCException("No robot one the picture"));
        orientation = picture.pixelAt(position).orientation();
        visitedPositions.add(position);
        this.initialDisplacement = moveForwardAsMuchAsPossible();

    }


}
