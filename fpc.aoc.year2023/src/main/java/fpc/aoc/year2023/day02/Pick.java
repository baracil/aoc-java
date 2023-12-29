package fpc.aoc.year2023.day02;

public record Pick(int red, int green, int blue) {



  public boolean isValid(Pick max) {
    return red<=max.red && green <= max.green && blue <= max.blue;
  }


  public Pick max(Pick other) {
    return new Pick(Math.max(this.red,other.red), Math.max(this.green,other.green), Math.max(this.blue,other.blue));
  }

  public final static Pick ZERO = new Pick(0,0,0);

  public static Pick parse(String pickAsString) {
    int red = 0;
    int green = 0;
    int blue = 0;

    final var colors = pickAsString.split(",");
    for (String color : colors) {
      final var token = color.trim().split(" ");
      final var value = Integer.parseInt(token[0]);
      switch (token[1]) {
        case "red" -> red = value;
        case "green" -> green = value;
        case "blue" -> blue = value;
      }
    }

    return new Pick(red,green,blue);
  }
}
