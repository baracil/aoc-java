package fpc.aoc.launcher._private;

import fpc.aoc.api.*;
import fpc.aoc.common.AOCException;
import lombok.NonNull;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class SolverService {

  public static Stream<Solver> loadSolvers() {
    return ServiceLoader.load(Solver.class)
        .stream()
        .map(ServiceLoader.Provider::get)
        .filter(p -> !p.isSkipped());
  }

  public static Stream<Solver> loadSolvers(@NonNull Predicate<SolverId> filter) {
    return loadSolvers().filter(p -> filter.test(p.id()));
  }

  public static Stream<Solver> loadSolversForAYear(Year year) {
    return loadSolvers(s -> s.matches(year));
  }


  public static Solver findLastDefinedSolver() {
    return loadSolvers()
        .max(Solver.CHRONOLOGICAL)
        .orElseThrow(() -> new AOCException("No Solver could be found"));
  }

  @NonNull
  public static Optional<DayId> findLastDay(Year year) {
    final var day = loadSolversForAYear(year)
        .map(Solver::id)
        .map(SolverId::day)
        .max(Day.DAY_COMPARATOR);
    return day.map(d -> new DayId(year, d));
  }

  @NonNull
  public static Optional<DayId> findLastDay() {
    return loadSolvers()
        .sorted(Solver.CHRONOLOGICAL)
        .map(Solver::id)
        .map(SolverId::dayId)
        .max(DayId::compareTo);
  }

  public static Optional<Solver> findSolverById(@NonNull SolverId id) {
    return loadSolvers()
        .filter(p -> id.equals(p.id()))
        .findFirst();
  }

  public static Optional<Solver> findSolverById(@NonNull Year year, @NonNull Day day, @NonNull Part part) {
    return findSolverById(year.createIdWith(day, part));
  }

  public static Optional<Solver> findSolverById(@NonNull String yearAsString, @NonNull String dayAsString, @NonNull String partAsString) {
    final Year year = Year.parse(yearAsString);
    final Day day = Day.parse(dayAsString);
    final Part part = Part.parse(partAsString);
    return findSolverById(year, day, part);
  }

  public static Solver getSolverById(@NonNull SolverId solverId) {
    return findSolverById(solverId).orElseThrow(() -> new AOCException("Could not find a problem with id " + solverId));
  }

  public static Solver getSolverById(@NonNull Year year, @NonNull Day day, @NonNull Part part) {
    final var solverId = new SolverId(year, day, part);
    return getSolverById(solverId);
  }


  public static Stream<Solver> loadSolversOfADay(@NonNull DayId dayId) {
    return loadSolvers(id -> id.matches(dayId));
  }

  public static Solver getSolverById(@NonNull String yearAsString, @NonNull String dayAsString, @NonNull String partAsString) {
    final Year year = Year.parse(yearAsString);
    final Day day = Day.parse(dayAsString);
    final Part part = Part.parse(partAsString);
    return getSolverById(year, day, part);
  }


  public static Solver findSolverFromArgs(String[] args) {
    return switch (args.length) {
      case 0 -> findLastDefinedSolver();
      case 3 -> SolverService.getSolverById(args[0], args[1], args[2]);
      default ->
          throw new AOCException("Invalid arguments. Either no argument or 3 arguments (year & day & part) must be provided");
    };
  }
}
