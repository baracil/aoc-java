package fpc.aoc.year2019.day1;

public class FuelRequirement {

    public static int basicFuelRequirement(int mass) {
        return Math.max(0,mass/3-2);
    }

    public static int correctedFuelRequirement(int mass) {
        final int fuel = basicFuelRequirement(mass);
        if (fuel == 0) {
            return fuel;
        }
        return fuel+correctedFuelRequirement(fuel);
    }
}
