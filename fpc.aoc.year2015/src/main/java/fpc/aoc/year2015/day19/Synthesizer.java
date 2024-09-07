package fpc.aoc.year2015.day19;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//167 too low
@RequiredArgsConstructor
public class Synthesizer {


  public static long synthesize(Input input) {
    return new Synthesizer(input).synthesize();
  }

  private final Input input;
  private String structure;
  private int count = 0;


  private long synthesize() {
    this.split();
    while (replace()) ;
    return count;
  }

  private boolean replace() {
    if (replace("..")) {
      return true;
    }
    if (replace(".X.Z")) {
      return true;
    }
    if (replace(".X.Y.Z")) {
      return true;
    }
    if (replace(".X.Y.Y.Z")) {
      return true;
    }

    return false;
  }

  private boolean replace(String template) {
    final var idx = structure.lastIndexOf(template);
    if (idx < 0) {
      return false;
    }
    count++;
    final var start = structure.substring(0,idx);
    final var end = structure.substring(idx+template.length());
    this.structure = start+"."+end;
    return true;

  }


  private void split() {
    final var sb = new StringBuilder();
    int i = 0;
    final var molecule = input.molecule();
    while (i < molecule.length()) {
      final var token = nextToken(molecule, i);
      i += token.length();
      sb.append(switch (token) {
        case "Rn" -> "X";
        case "Ar" -> "Z";
        case "Y" -> "Y";
        default -> ".";
      });
      final var e = new Token(token);
    }
    this.structure = sb.toString();
  }

  private String nextToken(String molecule, int index) {
    final var sub1 = molecule.substring(index, index + 1);
    if (input.isReactant(sub1) || sub1.equals("Y")) {
      return sub1;
    }
    return molecule.substring(index, index + 2);
  }


  @Getter
  public class Token {
    String value;
    boolean reactant;

    public Token(String value) {
      this.value = value;
      this.reactant = input.isReactant(value);
    }

    public void setValue(String value) {
      this.value = value;
      this.reactant = input.isReactant(value);
    }

    @Override
    public String toString() {
      return value;
    }
  }

}
