package fpc.aoc.common;

import lombok.NonNull;

import java.io.PrintStream;

public class BaseGenericArray<T> extends BaseArray implements GenericArray<T> {

    private final @NonNull T[] data;

    public BaseGenericArray(@NonNull T[] data, int width, int height) {
        super(width, height);
        this.data = data;
    }

    @Override
    public @NonNull T get(@NonNull Position position) {
        return get(position.x(),position.y());
    }

    @Override
    public @NonNull T get(int x, int y) {
        if (isInRange(x,y)) {
            return data[xyToIndex(x,y)];
        }
        throw new IndexOutOfBoundsException("x="+x+" y="+y+"  width="+width()+" height="+height());
    }


    @Override
    protected void printSingleElement(@NonNull PrintStream printStream, int elementIndex) {
        printStream.println(data[elementIndex]);
    }
}
