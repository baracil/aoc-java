package fpc.aoc.year2022.day13;

public class ItemComparator {


  public static int compare(Item.Scalar s1, Item.Scalar s2) {
    return s1.value() - s2.value();
  }

  public static int compare(Item.List l1, Item.Scalar s2) {
    return -compare(s2, l1);
  }

  public static int compare(Item.Scalar s1, Item.List l2) {
    if (l2.isEmpty()) {
      return 1;
    }
    final var cmp = s1.compareTo(l2.get(0));
    if (cmp == 0) {
      return -1;
    }
    return cmp;
  }

  public static int compare(Item.List l1, Item.List l2) {
    int i = 0;
    while (i < l1.size() && i < l2.size()) {
      final int cmp = l1.get(i).compareTo(l2.get(i));
      if (cmp != 0) {
        return cmp;
      }
      i++;
    }
    return l1.size() - l2.size();
  }

}
