package fpc.aoc.year2021.day16;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day16.struct.Packet;
import fpc.aoc.year2021.day16.struct.PacketReader;
import lombok.NonNull;

public abstract class Day16Solver extends SmartSolver<Packet> {

    @Override
    protected @NonNull Converter<Packet> getConverter() {
        return Converter.FIRST_LINE.andThen(PacketReader::read);
    }
}
