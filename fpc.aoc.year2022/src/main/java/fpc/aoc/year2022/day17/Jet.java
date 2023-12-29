package fpc.aoc.year2022.day17;

import lombok.NonNull;

public class Jet {

  private final JetDirection[] directions;



  public Jet(@NonNull String line) {
    this.directions = line.chars()
        .mapToObj(JetDirection::get)
        .toArray(JetDirection[]::new);
  }

  public @NonNull JetDirection getJetDirection(int index) {
    return directions[index%directions.length];
  }


  public int increaseIndex(int jetIndex) {
    return (jetIndex+1)%directions.length;
  }
}
