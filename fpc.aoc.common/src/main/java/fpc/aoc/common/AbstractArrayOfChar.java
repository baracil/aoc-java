package fpc.aoc.common;

import lombok.NonNull;

public abstract class AbstractArrayOfChar implements ArrayOfChar {

    private final LazyString asString = LazyString.of(this::computeAsString);

    @Override
    public @NonNull String asString() {
        return asString.toString();
    }

    public @NonNull String computeAsString() {
        final int height = height();
        final int width = width();
        final StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            if (y != 0) {
                sb.append('\n');
            }
            for (int x = 0; x < width; x++) {
                sb.append(get(x, y));
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return asString();
    }
}
