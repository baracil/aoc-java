package fpc.aoc.year2022.day13;

import fpc.aoc.common.AOCException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemParserWithStack {

  public static Item parse(String line) {
    return new ItemParserWithStack(line).parse();
  }


  //invariant line is a int or the full content of a list without the []
  private final String line;
  private final Deque<List<Item>> pending = new LinkedList<>();

  private int idx = 0;
  private int idxNextSeparator = -1;

  private Item parse() {

    while (true) {
      idx = idxNextSeparator;
      idxNextSeparator = findNextSeparator();
      char nextSeparator = line.charAt(idxNextSeparator);
      if (nextSeparator == '[') {
        pending.add(new ArrayList<>());
      } else if (nextSeparator == ']') {
        extractPotentialScalar();
        final var item = new Item.List(pending.removeLast());
        if (pending.isEmpty()) {
          return item;
        }
        pending.peekLast().add(item);
      } else if (nextSeparator == ',') {
        extractPotentialScalar();
      }
    }

  }

  private void extractPotentialScalar() {
    final var sub = line.substring(idx + 1, idxNextSeparator);
    if (sub.isEmpty()) {
      return;
    }
    final var item = new Item.Scalar(Integer.parseInt(sub));
    pending.peekLast().add(item);
  }

  private int findNextSeparator() {
    var i = idx;
    while ((++i) < line.length()) {
      final var c = line.charAt(i);
      if (c == '[' || c == ']' || c == ',') {
        return i;
      }
    }
    throw new AOCException("Could not parse line '" + line + "'");
  }


}
