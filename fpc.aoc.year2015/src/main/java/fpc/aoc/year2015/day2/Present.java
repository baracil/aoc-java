package fpc.aoc.year2015.day2;

public record Present(int length, int width, int height) {

  public int paperArea() {
    final var s1 = length * width;
    final var s2 = width * height;
    final var s3 = height * length;
    return 2 * (s1 + s2 + s3)+Math.min(s1,Math.min(s2,s3));
  }

  public int ribbonLength() {
    final var sum=  length+width+height;
    final var prod=  length*width*height;

    return prod+2*(sum-Math.max(length,Math.max(height,width)));
  }


  public static Present parse(String line) {
    final var tokens = line.split("x");
    return new Present(
      Integer.parseInt(tokens[0]),
      Integer.parseInt(tokens[1]),
      Integer.parseInt(tokens[2])
    );
  }

}
