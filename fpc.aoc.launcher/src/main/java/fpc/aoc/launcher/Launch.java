package fpc.aoc.launcher;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import fpc.aoc.launcher._private.Launcher;

@RequiredArgsConstructor
public class Launch {

    public static void main(String[] args) {
        final double last = bench(new Problem(args),0,1);
        System.out.printf("Last : %.3f ms%n",last);
    }

    public static double bench(@NonNull Problem problem, int warmup, int bench) {
        for (int i = 0; i < warmup; i++) {
            Launcher.launch(problem);
        }
        final long start = System.nanoTime();
        for (int i = 0; i < bench; i++) {
            Launcher.launch(problem);
        }
        final long last = System.nanoTime() - start;
        return last*1e-6/bench;

    }

}

