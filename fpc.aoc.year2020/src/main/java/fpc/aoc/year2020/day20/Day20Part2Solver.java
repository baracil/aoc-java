package fpc.aoc.year2020.day20;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Pattern;
import fpc.aoc.common.Transformation;
import fpc.aoc.year2020.day20.structures.ImageArray;
import lombok.NonNull;

public class Day20Part2Solver extends Day20Solver {

    public static @NonNull Solver provider() {
        return new Day20Part2Solver();
    }

    private static final String MONSTER = """
                              #\s
            #    ##    ##    ###
             #  #  #  #  #  #  \s
             """;

    @Override
    public @NonNull Long doSolve(@NonNull ImageArray imageArray) {
        final var image = imageArray.buildImage();
        final var monster = new Pattern(MONSTER, '#');

        final long nbMonsters = Transformation.all()
                                              .map(image::transform)
                                              .mapToLong(i -> monster.numberOfMatches(i, '#'))
                                              .filter(l -> l > 0)
                                              .findFirst()
                                              .orElse(-1);

        final long nbSharps = image.positionStream().filter(p -> image.get(p) == '#').count();

        return nbSharps - nbMonsters*monster.nbPoints();
    }

}
