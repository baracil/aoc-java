package fpc.aoc.robot;

import lombok.NonNull;

/**
 * @author perococco
 **/
public interface OrderProducer<T> {

    @NonNull
    Order<T> stop();

    @NonNull
    Order<T> sendData(@NonNull T data);
}
