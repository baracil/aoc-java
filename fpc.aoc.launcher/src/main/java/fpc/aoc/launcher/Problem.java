package fpc.aoc.launcher;

import lombok.NonNull;
import fpc.aoc.api.AOCProblem;
import fpc.aoc.api.AOCProblemId;
import fpc.aoc.api.Day;
import fpc.aoc.api.Part;
import fpc.aoc.common.AOCException;
import fpc.aoc.launcher._private.ProblemService;

import static fpc.aoc.launcher._private.ProblemService.findLastDefinedProblem;

public class Problem implements AOCProblem<Object> {

    private final AOCProblem<?> found;

    public Problem(@NonNull String[] args) {
        switch (args.length) {
            case 0 -> found = findLastDefinedProblem();
            case 2 -> found = ProblemService.getProblemById(args[0], args[1]);
            default -> throw new AOCException("Invalid arguments. Either no argument or 2 arguments (day & part) must be provided");
        }
    }

    public Problem(@NonNull Day day, @NonNull Part part) {
        found = ProblemService.getProblemById(day, part);
    }

    @Override
    public @NonNull AOCProblemId id() {
        return found.id();
    }

    @Override
    public @NonNull Object solve() {
        return found.solve();
    }


}
