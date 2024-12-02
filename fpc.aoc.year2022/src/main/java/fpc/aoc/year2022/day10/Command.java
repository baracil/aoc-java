package fpc.aoc.year2022.day10;

public interface Command {

  int nbCycles();

  int applyToRegister(int registerValue);


  static Command parse(String line) {
    if (line.equals("noop")) {
      return new Noop();
    }
    return new AddX(Integer.parseInt(line.split(" ")[1]));
  }


  record Noop() implements Command {
    @Override
    public int nbCycles() {
      return 1;
    }

    @Override
    public int applyToRegister(int registerValue) {
      return registerValue;
    }

  }

  record AddX(int increment) implements Command {
    @Override
    public int nbCycles() {
      return 2;
    }

    @Override
    public int applyToRegister(int registerValue) {
      return registerValue + increment;
    }
  }

}
