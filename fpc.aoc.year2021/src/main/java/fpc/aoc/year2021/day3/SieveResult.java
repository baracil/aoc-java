package fpc.aoc.year2021.day3;

import lombok.NonNull;

import java.util.stream.Collector;

public sealed interface SieveResult {
    record SingleValue(int value) implements SieveResult {}
    record Balance(BitBalance bitBalance) implements SieveResult {}

    static @NonNull Collector<Integer,?,SieveResult> collector(int sieveValue, int sieveMask, int bitMask) {
        class Aggregator {
            int nbMatching;
            int oneValue;
            int count;

            public void pushOneValue(int value) {
                if ((value&sieveMask) == sieveValue) {
                    nbMatching++;
                    oneValue = value;
                    count += ((value&bitMask) == 0)?-1:1;
                }
            }
            public Aggregator combine(Aggregator other) {
                this.nbMatching += other.nbMatching;
                if (other.nbMatching > 0) {
                    this.oneValue = other.oneValue;
                }
                this.count += other.count;
                return this;
            }
            public SieveResult build() {
                if (nbMatching == 1) {
                    return new SingleValue(this.oneValue);
                }
                return new Balance(BitBalance.fromBalanceCount(count));
            }
        }

        return Collector.of(Aggregator::new, Aggregator::pushOneValue, Aggregator::combine,Aggregator::build);
    }



}
