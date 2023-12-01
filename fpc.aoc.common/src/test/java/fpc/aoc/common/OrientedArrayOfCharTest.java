package fpc.aoc.common;

import org.junit.jupiter.api.Test;

public class OrientedArrayOfCharTest {

    @Test
    public void name() {
        final ArrayOfChar a = ArrayOfChar.from("""
                                                       ...##
                                                       ....#
                                                       .....
                                                       ##...
                                                       ##..#
                                                       """, '.');
        for (Rotation value : Rotation.values()) {
            var o = a.rotate(value);
            System.out.println(value);
            System.out.println(o);
            System.out.println("Top   -> "+o.upperBorder());
            System.out.println("Right -> "+o.rightBorder());
            System.out.println("Down  -> "+o.lowerBorder());
            System.out.println("Left  -> "+o.leftBorder());
        }
    }
}
