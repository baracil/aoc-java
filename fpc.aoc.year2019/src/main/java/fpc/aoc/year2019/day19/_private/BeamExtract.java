package fpc.aoc.year2019.day19._private;

/**
 * @author Bastien Aracil
 **/
public class BeamExtract {

    private final int shipSize;

    private final BeamSlice[] slices;

    private int idx = 0;
    private int size = 0;

    public BeamExtract(int shipSize) {
        this.shipSize = shipSize;
        this.slices = new BeamSlice[shipSize];
    }

    public void push(BeamSlice slice) {
        if (size<shipSize) {
            size++;
        }
        slices[idx] = slice;
        idx = increment(idx);
    }


    public boolean canFitTheShip() {
        if (size<shipSize) {
            return false;
        }
        final BeamSlice last = get(shipSize-1);
        if (last.length()<shipSize) {
            return false;
        }

        final int xStart = last.start().x();

        for (int i = 0; i < shipSize-1; i++) {
            final BeamSlice slice = get(i);
            if (!slice.contain(xStart,shipSize)) {
                return false;
            }
        }
        return true;
    }

    private BeamSlice get(int idx) {
        return slices[(idx+this.idx)%shipSize];
    }

    public int increment(int index) {
        return (index+1)%shipSize;
    }


}
