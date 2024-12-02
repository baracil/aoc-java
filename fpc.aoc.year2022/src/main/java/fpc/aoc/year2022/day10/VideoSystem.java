package fpc.aoc.year2022.day10;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class VideoSystem {

  private int x = 1;
  private int cycle = 1;
  private final Crt crt = new Crt();

  @Getter
  private final List<Integer> signalStrength = new ArrayList<>(220);

  public void execute(CommandProvider commandProvider) {
    Command pending = null;
    int nbCycleBeforeExecution = 0;

    signalStrength.add(0);

    do {

      final var col = ((cycle - 1) % 40);

      if (Math.abs(x - col) <= 1) {
        crt.drawPixel(cycle);
      }
      final var st = cycle * x;
      signalStrength.add(st);

      if (nbCycleBeforeExecution == 0) {
        pending = commandProvider.takeCommand().orElse(null);
        if (pending != null) {
          nbCycleBeforeExecution = pending.nbCycles();
        }
      }
      cycle++;
      nbCycleBeforeExecution--;

      if (nbCycleBeforeExecution == 0) {
        this.x = pending.applyToRegister(this.x);
      }


    } while (pending != null);
  }

  public String dumpDisplay() {
    return crt.dumpDisplay();
  }
}


