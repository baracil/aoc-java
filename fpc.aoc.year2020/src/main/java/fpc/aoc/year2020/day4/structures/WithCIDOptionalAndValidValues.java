package fpc.aoc.year2020.day4.structures;

import lombok.NonNull;

import java.util.Arrays;
import java.util.function.Predicate;

public class WithCIDOptionalAndValidValues implements ValidityRule {

    @Override
    public boolean isValid(@NonNull Passport passport) {
        final Predicate<FieldName> fieldValidity = f -> isFieldValid(passport, f);
        return Arrays.stream(FieldName.values())
                     .allMatch(fieldValidity);
    }

    private boolean isFieldValid(@NonNull Passport passport, @NonNull FieldName fieldName) {
        if (fieldName == FieldName.CID) {
            return true;
        }
        return passport.getField(fieldName)
                       .map(fieldName::isValid)
                       .orElse(false);
    }
}
