package fpc.aoc.computer.io;

import lombok.NonNull;

import java.util.function.Function;

public interface OutputTransformer<W> extends Function<String,W> {

    OutputTransformer<String> NONE = s -> s;

    OutputTransformer<String> ADD_NEW_LINE = s -> s + System.lineSeparator();

    OutputTransformer<String> TO_ASCII = s -> String.valueOf(((char)Long.parseLong(s)));

    @NonNull
    W transform(String s);


    @Override
    default W apply(String s) {
        return transform(s);
    }

    @NonNull
    default <V> OutputTransformer<V> then(Function<? super W,? extends V> after) {
        return s -> after.apply(this.transform(s));
    }
}
