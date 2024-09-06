package fpc.aoc.year2019.day14.computation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ChemicalReaction {

    @NonNull
    @Getter
    private final Chemical producedChemical;

    @Getter
    private final int producedAmount;

    @NonNull
    @Singular
    private final List<Reactant> reactants;

    @Override
    public String toString() {
        return reactants.stream()
                        .map(Reactant::toString)
                        .collect(Collectors.joining(", ",""," => "))
                +producedAmount+" "+producedChemical.name();
    }


    public void forEachReactant(@NonNull Consumer<Reactant> reactantConsumer) {
        reactants.forEach(reactantConsumer);
    }
}
