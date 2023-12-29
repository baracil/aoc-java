package fpc.aoc.year2021.day19.struct;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Builder
@RequiredArgsConstructor
public class Report {
    @Singular
    private final Set<Vector> beacons;




    public @NonNull Report merge(@NonNull Report report) {
        final Set<Vector> vectors = new HashSet<>();
        vectors.addAll(this.beacons);
        vectors.addAll(report.beacons);
        return new Report(vectors);
    }

    public @NonNull Report applyTransformation(Match match) {
        return this.rotate(match.rotationIdx()).translate(match.offset());
    }

    public @NonNull Report rotate(int rotationIdx) {
        final var beacons = this.beacons.stream().map(p -> p.rotate(rotationIdx)).collect(Collectors.toSet());
        return new Report(beacons);
    }

    public @NonNull Report translate(@NonNull Vector offset) {
        final var beacons = this.beacons.stream().map(p -> p.add(offset)).collect(Collectors.toSet());
        return new Report(beacons);
    }


    public Optional<Match> findMatching(@NonNull Report other) {
        return IntStream.range(0, 24)
                .mapToObj(rotation -> findMatching(other, rotation))
                .flatMap(Optional::stream)
                .max(Comparator.comparing(Match::nbMatch));
    }

    private Optional<Match> findMatching(Report other, int rotation) {
        final var transformed = other.rotate(rotation);

        final Map<Vector, Long> collect = this.beacons.stream()
                .flatMap(p1 -> transformed.beacons.stream().map(p1::subtract))
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()));

        return collect.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(entry -> new Match(rotation, entry.getKey(), entry.getValue().intValue()))
                .filter(m -> m.nbMatch()>1);
    }

}
