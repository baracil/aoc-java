package fpc.aoc.computer;

import lombok.NonNull;

public interface AlterationConsumer {

    void handleAlteration(int address, @NonNull String value);
}
