package fpc.aoc.year2022.day13;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemParserWithRecurse {

  public static Item parse(String line) {
    return new ItemParserWithRecurse(line).parse();
  }


  //invariant line is a int or the full content of a list without the []
  private final @NonNull String line;

  private Item parse() {
    if (!line.startsWith("[")) {
      return new Item.Scalar(Integer.parseInt(line));
    }
    if (line.equals("[]")) {
      return new Item.List(List.of());
    }
    int idx = 0;
    final List<Item> result = new ArrayList<>();
    while (idx < line.length()) {
      final int end = findNextSeparator(idx);
      if (end<0) {
        break;
      }
      result.add(ItemParserWithRecurse.parse(line.substring(idx + 1, end)));
      idx = end;
    }

    return new Item.List(result);
  }

  private int findNextSeparator(int idx) {
    int nextSepIndex = idx+1;
    int nbOpened = 0;
    while(nextSepIndex<line.length()) {
      final var c = line.charAt(nextSepIndex);
      if (c == ',' && nbOpened == 0) {
        return nextSepIndex;
      }
      else if (c == '[') {
        nbOpened++;
      } else if (c == ']') {
        if (nbOpened == 0) {
          return nextSepIndex;
        }
        nbOpened--;
      }
      nextSepIndex++;
    }
    return -1;
  }


}
