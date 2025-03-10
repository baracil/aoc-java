package fpc.aoc.computer;

import fpc.aoc.computer._private.PrivateAlterations;
import lombok.NonNull;

public interface Alterations {

    @NonNull
    static Alterations with(int address, String value) {
        return none().addAlterations(address, value);
    }

    @NonNull
    static Alterations with(int address, String value1, String value2) {
        return none().addAlterations(address, value1, value2);
    }

    @NonNull
    static Alterations none() {
        return PrivateAlterations.none();
    }

    void handleAlterations(AlterationConsumer consumer);

    @NonNull
    Alterations addAlterations(int address, String value);

    @NonNull
    Alterations addAlterations(int address, String value1, String value2);

}
