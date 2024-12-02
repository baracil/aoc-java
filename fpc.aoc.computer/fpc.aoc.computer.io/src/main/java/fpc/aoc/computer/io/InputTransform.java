package fpc.aoc.computer.io;

import lombok.NonNull;

import java.util.List;
import java.util.function.Function;

public interface InputTransform<R> extends Function<R,String> {

    InputTransform<String> NONE = s -> s;

    InputTransform<String> ADD_NEW_LINE = s->s+"\n";

    @Override
    default String apply(R value) {
        return transform(value);
    }

    @NonNull
    String transform(R value);

    @NonNull
    default InputMultiTransformer<R> toMulti() {
        return r -> List.of(this.apply(r));
    }

    @NonNull
    default InputMultiTransformer<R> then(InputMultiTransformer<String> after) {
        return r -> after.transform(apply(r));
    }
}
