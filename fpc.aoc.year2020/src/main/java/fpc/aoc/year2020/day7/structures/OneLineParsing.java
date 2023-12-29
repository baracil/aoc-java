package fpc.aoc.year2020.day7.structures;


import lombok.Getter;
import lombok.NonNull;

import java.util.Map;

@Getter
public record OneLineParsing(@NonNull String colorName, @NonNull Map<String, Integer> content) {

}
