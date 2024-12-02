package fpc.aoc.robot;

import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public interface OrderProducer<T> {

    @NonNull
    Order<T> stop();

    @NonNull
    Order<T> sendData(T data);
}
