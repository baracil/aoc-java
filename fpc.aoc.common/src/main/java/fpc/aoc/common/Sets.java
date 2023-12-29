package fpc.aoc.common;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class Sets {

  public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
    final Set<T> result = new HashSet<>(set1);
    result.addAll(set2);
    return result;
  }

}
