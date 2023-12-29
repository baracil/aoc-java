package fpc.aoc.year2020.day16;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Tools;
import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FieldsMatcher {

    private final @NonNull Set<Field> fields;

    private final @NonNull Mask mask;

    private final @NonNull Map<Field, Set<Integer>> matchingPositions;

    private final int numberOfFields;

    public FieldsMatcher(Set<Field> allFields) {
        this.mask = Mask.create(allFields);
        this.fields = allFields;
        this.numberOfFields = allFields.size();
        this.matchingPositions = allFields.stream()
                                          .collect(Collectors.toMap(f -> f, f -> allPositions(numberOfFields)));
    }

    private static Set<Integer> allPositions(int numberOfFields) {
        return IntStream.range(0, numberOfFields).boxed().collect(Collectors.toSet());
    }

    public void testTicket(@NonNull Ticket ticket) {
        if (!mask.isValid(ticket)) {
            return;
        }
        for (int position = 0; position < numberOfFields; position++) {
            final var value = ticket.getValueAt(position);
            for (Field field : fields) {
                final var matchingPosition = matchingPositions.get(field);
                if (!field.isValid(value)) {
                    matchingPosition.remove(position);
                }
                if (matchingPosition.isEmpty()) {
                    throw new AOCException("No field associated with position " + position + " for value " + value);
                }
            }

        }
    }

    public @NonNull Optional<Map<Field, Integer>> getSolution() {
        final Map<Field, Integer> solution = new HashMap<>();
        for (Field field : matchingPositions.keySet()) {
            final var matchingPosition = matchingPositions.get(field);
            if (matchingPosition.size() != 1) {
                return Optional.empty();
            }
            solution.put(field, Tools.getOneElement(matchingPosition));
        }
        return Optional.of(solution);
    }

    public void cleanUp() {
        Set<Field> fieldToCheck = getInitialFieldsToCheck();
        while (!fieldToCheck.isEmpty()) {
            fieldToCheck = cleanUp(fieldToCheck);
        }
    }

    private @NonNull Set<Field> getInitialFieldsToCheck() {
        return matchingPositions.keySet()
                                .stream()
                                .filter(f -> matchingPositions.get(f).size() == 1)
                                .collect(Collectors.toSet());
    }

    private Set<Field> cleanUp(@NonNull Set<Field> fieldToCheck) {
        final Set<Field> changedFields = new HashSet<>();
        for (Field field : fieldToCheck) {
            final var matchingPosition = matchingPositions.get(field);
            if (matchingPosition.size() > 1) {
                continue;
            }
            final int resolvedPosition = Tools.getOneElement(matchingPosition);
            removeOnePosition(field, resolvedPosition, changedFields);
        }
        return changedFields;
    }

    private void removeOnePosition(@NonNull Field fieldToSkip, int positionToRemove, @NonNull Set<Field> changedFields) {
        for (var fieldSetEntry : matchingPositions.entrySet()) {
            final var field = fieldSetEntry.getKey();
            final var positions = fieldSetEntry.getValue();
            if (field.equals(fieldToSkip)) {
                continue;
            }
            if (positions.remove(positionToRemove)) {
                if (positions.size() == 1) {
                    changedFields.add(field);
                }
            }
        }
    }


}
