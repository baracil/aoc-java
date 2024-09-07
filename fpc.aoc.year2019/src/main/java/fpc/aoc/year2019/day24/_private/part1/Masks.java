package fpc.aoc.year2019.day24._private.part1;

import lombok.Value;

/**
 * @author Bastien Aracil
 **/
@Value
class Masks {

    int value;

    int one;

    int two;

    public void dump() {
        System.out.println("--- MASK ---");
        Layout.dump(value);
        System.out.println(" ONE ");
        Layout.dump(one);
        System.out.println(" TWO ");
        Layout.dump(two);
    }
}
