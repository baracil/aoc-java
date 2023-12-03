package fpc.aoc.launcher._private;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.api.AOCProblemId;
import fpc.aoc.api.Day;
import fpc.aoc.api.Part;
import fpc.aoc.common.AOCException;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class ProblemService {

    public static Stream<AOCProblem<?>> loadProblems() {
        return ServiceLoader.load(AOCProblem.class)
                            .stream()
                            .map(ServiceLoader.Provider::get)
                            .filter(p -> !p.isSkipped())
                            .map(p -> (AOCProblem<?>) p);
    }


    public static AOCProblem<?> findLastDefinedProblem() {
        return loadProblems()
                .max(AOCProblem::compareTo)
                .orElseThrow(() -> new AOCException("No AOCProblem could be found"));
    }

    @NonNull
    public static Optional<Day> findLastDay() {
        return loadProblems()
                .map(AOCProblem::id)
                .map(AOCProblemId::day)
                .max(Day.DAY_COMPARATOR);
    }

    public static Optional<? extends AOCProblem<?>> findProblemById(@NonNull AOCProblemId id) {
        return loadProblems()
                .filter(p -> id.equals(p.id()))
                .findFirst();
    }

    public static Optional<? extends AOCProblem<?>> findProblemById(@NonNull Day day, @NonNull Part part) {
        return findProblemById(day.createIdWith(part));
    }

    public static Optional<? extends AOCProblem<?>> findProblemById(@NonNull String dayAsString, @NonNull String partAsString) {
        final Day day = Day.parse(dayAsString);
        final Part part = Part.parse(partAsString);
        return findProblemById(day, part);
    }

    public static List<? extends AOCProblem<?>> listProblems(@NonNull Predicate<AOCProblemId> filter) {
        return loadProblems().filter(p -> filter.test(p.id())).toList();
    }

    public static List<? extends AOCProblem<?>> listProblemsOfADay(@NonNull Day day) {
        return listProblems(id -> id.day().equals(day));
    }

    public static AOCProblem<?> getProblemById(@NonNull String dayAsString, @NonNull String partAsString) {
        final Day day = Day.parse(dayAsString);
        final Part part = Part.parse(partAsString);
        return getProblemById(day, part);
    }

    public static AOCProblem<?> getProblemById(@NonNull Day day, @NonNull Part part) {
        final AOCProblemId problemId = new AOCProblemId(day, part);
        return findProblemById(day, part).orElseThrow(() -> new AOCException("Could not find a problem with id " + problemId));
    }

}
