package fpc.aoc.year2022.day17;

public class Jet {

  private final JetDirection[] directions;


  public Jet(String line) {
    this.directions = line.chars()
        .mapToObj(JetDirection::get)
        .toArray(JetDirection[]::new);
  }

  public JetDirection getJetDirection(int index) {
    return directions[index % directions.length];
  }


  public int increaseIndex(int jetIndex) {
    return (jetIndex + 1) % directions.length;
  }
}
