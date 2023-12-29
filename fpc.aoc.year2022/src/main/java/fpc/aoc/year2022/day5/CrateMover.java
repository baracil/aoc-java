package fpc.aoc.year2022.day5;

import lombok.NonNull;

public interface CrateMover {

  void performProcedureStep(@NonNull Stacks stacks, @NonNull ProcedureStep procedureStep);

}
