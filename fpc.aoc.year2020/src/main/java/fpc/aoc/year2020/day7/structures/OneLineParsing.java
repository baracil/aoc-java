package fpc.aoc.year2020.day7.structures;


import lombok.NonNull;

import java.util.Map;

public record OneLineParsing(@NonNull String colorName, @NonNull Map<String, Integer> content) {

}
