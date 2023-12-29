package fpc.aoc.year2021.day14.struct;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DefaultCache implements Cache {

    private final Map<Couple, Map<Integer,Distribution>> cachedDistributions = new HashMap<>();


    @Override
    public @NonNull Optional<Distribution> fromCache(@NonNull Couple couple, int generation) {
        return Optional.ofNullable(cachedDistributions.get(couple)).map(m -> m.get(generation));
    }

    @Override
    public void saveInCache(@NonNull Couple couple, int generation, @NonNull Distribution distribution) {
        this.cachedDistributions.computeIfAbsent(couple,c -> new HashMap<>()).put(generation,distribution);
    }
}
