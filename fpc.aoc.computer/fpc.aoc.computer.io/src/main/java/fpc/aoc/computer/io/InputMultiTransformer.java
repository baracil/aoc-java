package fpc.aoc.computer.io;

import fpc.aoc.common.Tools;
import lombok.NonNull;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface InputMultiTransformer<R> extends Function<R,List<String>> {

    InputMultiTransformer<String> TO_ASCII = Tools::convertToAscii;

    @Override
    @NonNull
    default List<String> apply(@NonNull R r) {
        return transform(r);
    }

    @NonNull
    List<String> transform(@NonNull R r);

    @NonNull
    default InputMultiTransformer<R> before(UnaryOperator<R> preparator) {
        return r -> transform(preparator.apply(r));
    }
}
