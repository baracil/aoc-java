package fpc.aoc.year2020.day19.structures;

import lombok.NonNull;
import lombok.Value;

@Value
public class IndexedString {

    public static @NonNull IndexedString initial(@NonNull String reference) {
        return new IndexedString(reference, 0);
    }

    @NonNull String reference;

    int offset;

    public char charAt(int idx) {
        return reference.charAt(idx+offset);
    }

    public @NonNull IndexedString addToOffset(int value) {
        return new IndexedString(reference, value+offset);
    }

    public boolean isEmpty() {
        return offset>=reference.length();
    }

    @Override
    public String toString() {
        return "IndexedString{" + reference.substring(offset) + "}";
    }
}
