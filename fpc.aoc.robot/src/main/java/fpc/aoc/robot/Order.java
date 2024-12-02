package fpc.aoc.robot;

import fpc.aoc.robot._private.PrivateOrderProducer;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface Order<T> {

    @NonNull
    static <T> OrderProducer<T> createMulti(Function<? super T, ? extends List<String>> dataTransformer) {
        return new PrivateOrderProducer<>(dataTransformer);
    }

    @NonNull
    static <T> OrderProducer<T> create(Function<? super T, ? extends String> dataTransformer) {
        return createMulti(data -> List.of(dataTransformer.apply(data)));
    }

    boolean stopRobot();

    @NonNull
    Optional<T> source();

    @NonNull
    List<String> dataToSend();


}
