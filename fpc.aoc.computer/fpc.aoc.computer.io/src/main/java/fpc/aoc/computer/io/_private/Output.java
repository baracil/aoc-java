package fpc.aoc.computer.io._private;

import lombok.NonNull;

import java.util.function.Consumer;

public interface Output {

    void write(String value);

    @NonNull
    default Output then(Consumer<? super String> after) {
        return s->{this.write(s);after.accept(s);};
    }


}
