package fpc.aoc.year2019.day14.computation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@RequiredArgsConstructor
public class ReversedFactory {

    @NonNull
    private final ChemicalBook chemicalBook;

    private final SortedMap<Chemical,Long> requiredQuantities = new TreeMap<>();

    private final Map<Chemical,Long> leftOvers = new HashMap<>();

    @Getter
    private long requiredOre;


    private final Map<Chemical,Long> produced = new HashMap<>();


    public void clear() {
        this.requiredQuantities.clear();
        this.leftOvers.clear();
        this.requiredOre = 0L;
    }

    public long getProduced(Chemical chemical) {
        return produced.getOrDefault(chemical,0L);
    }

    public void produce(Chemical target, long quantity) {
        produced.merge(target,quantity,Long::sum);
        addRequirement(target,quantity);

        while (!requiredQuantities.isEmpty()) {
            final Chemical chemical = requiredQuantities.lastKey();
            final long requiredAmount = requiredQuantities.remove(chemical);

            final long amountFromLeftOver = getSomeChemicalFromLeftOvers(chemical,requiredAmount);
            final long amountToProduce = requiredAmount - amountFromLeftOver;
            decompose(chemical, amountToProduce);
        }
    }

    private void decompose(Chemical chemical, long requiredAmount) {
        final ChemicalReaction reaction = chemicalBook.getReactionProducing(chemical);
        final long nbReactions = 1+(requiredAmount-1)/reaction.producedAmount();

        final long produced = nbReactions * reaction.producedAmount();
        reaction.forEachReactant(reactant -> addRequirement(reactant.chemical(), nbReactions*reactant.amount()));

        this.addToLeftOver(chemical,produced-requiredAmount);
    }

    private void addToLeftOver(Chemical chemical, long leftOver) {
        if (leftOver>0) {
            leftOvers.merge(chemical, leftOver, Long::sum);
        }
    }


    private void addRequirement(Chemical chemical, long requiredAmount) {
        if (chemical.isOre()) {
            requiredOre = requiredOre + requiredAmount;
        } else {
            requiredQuantities.merge(chemical,requiredAmount,Long::sum);
        }
    }

    private long getSomeChemicalFromLeftOvers(Chemical chemical, long requestedAmount) {
        final long amountAvailableFromLeftOver = leftOvers.getOrDefault(chemical,0L);


        if (amountAvailableFromLeftOver == 0L)  {
            return 0L;
        }

        final long available;
        final long remainingLeftOver;
        if (amountAvailableFromLeftOver > requestedAmount) {
            available = requestedAmount;
            remainingLeftOver = amountAvailableFromLeftOver - requestedAmount;
        } else {
            available = amountAvailableFromLeftOver;
            remainingLeftOver = 0L;
        }



        if (remainingLeftOver == 0L) {
            leftOvers.remove(chemical);
        } else {
            leftOvers.put(chemical,remainingLeftOver);
        }

        return available;
    }

}
