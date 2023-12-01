package fpc.aoc.common;

import lombok.NonNull;

public interface GenericArray<T> extends Array {

    @NonNull T get(@NonNull Position position);

    @NonNull T get(int x, int y);

}
