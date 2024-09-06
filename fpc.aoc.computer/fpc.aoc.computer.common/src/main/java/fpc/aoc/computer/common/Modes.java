package fpc.aoc.computer.common;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Modes {

    @NonNull
    private final String modes;

    @NonNull
    public AccessMode accessMode(int parameterPosition) {
        final int pos = modes.length() - parameterPosition-1;
        if (parameterPosition < 0 || pos < 0) {
            return AccessMode.POSITION;
        }
        return AccessMode.get(modes.charAt(pos)-'0');
    }
}
