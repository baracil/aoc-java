package fpc.aoc.year2021.day13.struct;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

@RequiredArgsConstructor
@Getter
public class Input {

    private final Sheet sheet;

    private final List<Fold> folds;


    public static Collector<String, ?, Input> COLLECTOR = Collector.of(
            Acc::new,
            Acc::pushLine,
            Acc::combine,
            Acc::build
            );

    @NoArgsConstructor
    private static final class Acc {

        private final Set<Dot> dots = new HashSet<>();
        private final List<Fold> folds = new ArrayList<>();

        public boolean inDots = true;

        public @NonNull Input build() {
            return new Input(new Sheet(dots), folds);
        }

        public @NonNull Acc combine(@NonNull Acc other) {
            throw new UnsupportedOperationException();
        }

        public void pushLine(@NonNull String line) {
            if (line.isBlank()) {
                inDots = false;
                return;
            }

            if (inDots) {
                dots.add(Dot.parse(line));
            } else {
                folds.add(Fold.parse(line));
            }
        }

    }
}
