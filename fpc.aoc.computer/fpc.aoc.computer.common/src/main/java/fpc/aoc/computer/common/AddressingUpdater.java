package fpc.aoc.computer.common;

import lombok.NonNull;

public interface AddressingUpdater {

    @NonNull
    Addressing updateAddressing(@NonNull Addressing currentPointer);

    @NonNull
    static AddressingUpdater nop() {
        return a -> a;
    }

    @NonNull
    static AddressingUpdater skipAbsolute(int nbToSkip) {
        if (nbToSkip == 0) {
            return nop();
        }
        return a -> a.addToAbsolute(nbToSkip);
    }

    @NonNull
    static AddressingUpdater jumpAbsolute(int newAddress) {
        return a -> a.jumpAbsolute(newAddress);
    }


}
