package fpc.aoc.year2020.day14.structures;

public class MemoryPart2 extends AbstractMemory {

    public void setValue(int address, long value) {
        getActiveMask().generateFloatingAddresses(address)
                  .forEach(addr -> putValueInMemory(addr,value));
    }

}
