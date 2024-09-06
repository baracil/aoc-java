package fpc.aoc.robot._private;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PrivateOrder {

    @NonNull
    public static PrivateOrder stop() {
        return new PrivateOrder(Type.STOP, List.of());
    }

    @NonNull
    public static PrivateOrder sendData(@NonNull List<String> data) {
        return new PrivateOrder(Type.SEND_DATA, data);
    }

    @NonNull
    public static PrivateOrder sendData(@NonNull String... data) {
        return sendData(List.of(data));
    }


    public enum Type {
        STOP,
        SEND_DATA
    }

    @NonNull
    private final Type type;

    @NonNull
    private final List<String> dataToSend;


}
