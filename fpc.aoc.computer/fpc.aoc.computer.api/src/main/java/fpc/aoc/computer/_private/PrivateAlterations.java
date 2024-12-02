package fpc.aoc.computer._private;

import fpc.aoc.common.Tools;
import fpc.aoc.computer.AlterationConsumer;
import fpc.aoc.computer.Alterations;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PrivateAlterations implements Alterations {

    private static final Alterations NONE = new PrivateAlterations();

    @NonNull
    private final List<Alteration> actions;

    public PrivateAlterations() {
        this.actions = List.of();
    }

    @Override
    public Alterations addAlterations(int address, String value) {
        return new PrivateAlterations(Tools.addValue(actions,new Alteration(address,value)));
    }

    @Override
    public Alterations addAlterations(int address, String value1, String value2) {
        return new PrivateAlterations(Tools.addValues(actions, new Alteration(address,value1),new Alteration(address+1,value2)));
    }

    @Override
    public void handleAlterations(AlterationConsumer consumer) {
        actions.forEach(a -> consumer.handleAlteration(a.address,a.value));
    }

    @NonNull
    public static Alterations none() {
        return NONE;
    }

    @RequiredArgsConstructor
    @Getter
    public static class Alteration {

        private final int address;

        @NonNull
        private final String value;

    }

}
