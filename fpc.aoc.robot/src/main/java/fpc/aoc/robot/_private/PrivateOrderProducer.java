package fpc.aoc.robot._private;

import fpc.aoc.robot.Order;
import fpc.aoc.robot.OrderProducer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Bastien Aracil
 **/
@RequiredArgsConstructor
public class PrivateOrderProducer<T> implements OrderProducer<T> {

    private final Order<?> STOP_ORDER = new Order<>() {
        @Override
        public boolean stopRobot() {
            return true;
        }

        @Override
        public Optional<Object> source() {
            return Optional.empty();
        }

        @Override
        public List<String> dataToSend() {
            return List.of();
        }
    };

    @NonNull
    private final Function<? super T, ? extends List<String>> dataTransformer;


    @SuppressWarnings("unchecked")
    @Override
    public Order<T> stop() {
        return (Order<T>)STOP_ORDER;
    }

    @Override
    public Order<T> sendData(T data) {
        return new Order<T>() {
            @Override
            public boolean stopRobot() {
                return false;
            }

            @Override
            public Optional<T> source() {
                return Optional.of(data);
            }

            @Override
            public List<String> dataToSend() {
                return PrivateOrderProducer.this.dataTransformer.apply(data);
            }
        };
    }
}
