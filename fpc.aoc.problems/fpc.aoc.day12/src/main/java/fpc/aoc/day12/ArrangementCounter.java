package fpc.aoc.day12;

import fpc.aoc.common.AOCException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ArrangementCounter {

  public static long count(Row row) {
    int[] minRequired = row.groupSizes().clone();
    for (int i = minRequired.length - 2; i >= 0; i--) {
      minRequired[i] += minRequired[i + 1] + 1;
    }
    minRequired[minRequired.length - 1] = 0;

    return new ArrangementCounter(row.line(), minRequired, row.groupSizes()).count();
  }


  private final String line2;
  private final int[] minRequired;
  private final int[] groupSizes;

  private final Map<State, Long> cache = new HashMap<>();


  private long count() {
    final var l = count2(new State(toNextNotOp(line2, 0), 0, 0));
    return l;
  }


  private int countKo(String line) {
    int c = 0;
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == '#') {
        c++;
      } else {
        break;
      }
    }
    return c;
  }


  private long count2(State state) {
    final var v = cache.get(state);
    if (v != null) {
      return v;
    }
    final var value = doCount2(state);
    cache.put(state, value);
    return value;
  }

  private long doCount2(State state) {
    if (state.allGroupMatches()) {
      return state.noKo() ? 1 : 0;
    }

    if (state.isTooShort()) {
      return 0;
    }

    if (state.isLineEmpty()) {
      return 0;
    }

    final var c = state.firstChar();
    if (c == '.') {
      throw new AOCException("Bug in algo");
    }

    int nbKo = countKo(state.line());
    if (nbKo > 0) {
      final var newState = state.nextWithNKo(nbKo);
      return newState == null ? 0 : count2(newState);
    }

    assert c == '?';

    final var ok = state.useOk();
    final var ko = state.useKo();

    final var valOk = ok == null ? 0 : count2(ok);
    final var valKo = ko == null ? 0 : count2(ko);

    return valOk + valKo;
  }

  private String toNextNotOp(String line, int idx) {
    for (int i = idx; i < line.length(); i++) {
      if (line.charAt(i) != '.') {
        return line.substring(i);
      }
    }
    return "";
  }

  @Value
  private class State {
    String line;
    int grp;
    int size;

    public char firstChar() {
      return line.charAt(0);
    }

    public boolean isLineEmpty() {
      return line.isEmpty();
    }

    public boolean allGroupMatches() {
      return grp >= groupSizes.length || (grp == groupSizes.length - 1 && size == groupSizes[grp]);
    }

    public boolean noKo() {
      return !line.contains("#");
    }

    public boolean isTooShort() {
      return line.length() + size < minRequired[grp];
    }

    public State nextWithNKo(int nc) {
      final var newSize = size + nc;
      final var groupSize = groupSizes[grp];

      if (newSize > groupSize) {
        return null;
      }

      if (newSize == groupSize) {
        final var sub = toNextNotOp(line, nc + 1);
        return new State(sub, grp + 1, 0);
      }

      final var c = nc >= line.length() ? '.' : line.charAt(nc);
      if (c == '.') {
        return null;
      }

      return new State(line.substring(nc), grp, newSize);
    }

    public State useKo() {
      final var groupSize = groupSizes[grp];
      if (groupSize == size) {
        return null;
      }

      final var newSize = size + 1;
      if (newSize > groupSize) {
        return null;
      }

      final var c = line.length() < 2 ? '.' : line.charAt(1);


      if (newSize == groupSize) {
        if (c == '#') {
          return null;
        }
        final var sub = toNextNotOp(line, 2);
        return new State(sub, grp + 1, 0);
      }

      if (c == '.') {
        return null;
      }
      return new State(line.substring(1), grp, newSize);
    }

    public State useOk() {
      final var groupSize = groupSizes[grp];
      if (groupSize == size) {
        return new State(toNextNotOp(line, 1), grp + 1, 0);
      } else if (size == 0) {
        return new State(toNextNotOp(line, 1), grp, 0);
      }
      return null;
    }
  }


}
