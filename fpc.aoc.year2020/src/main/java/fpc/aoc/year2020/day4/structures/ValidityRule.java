package fpc.aoc.year2020.day4.structures;

import lombok.NonNull;

public interface ValidityRule {

  boolean isValid(@NonNull Passport passport);
}
