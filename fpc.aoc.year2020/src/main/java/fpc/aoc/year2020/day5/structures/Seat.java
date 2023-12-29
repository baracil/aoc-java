package fpc.aoc.year2020.day5.structures;

import fpc.aoc.common.Table;
import lombok.NonNull;
import lombok.Value;

import java.util.Objects;

@Value
public class Seat {

    public static @NonNull Seat of(@NonNull String boardingPassId) {
        final Seat seat = PLANE_SEATS.get(boardingPassId.substring(0,7),boardingPassId.substring(7));
        return Objects.requireNonNull(seat);
    }

    int row;
    int columns;
    int id;

    public Seat(int row, int columns) {
        this.row = row;
        this.columns = columns;
        this.id = row*8+columns;
    }

    private final static Table<String,String,Seat> PLANE_SEATS;

    static {
        final Table<String,String,Seat> seats = Table.create();
        for (int r = 0; r < 128; r++) {
            final var rowId = toBinary(r, 'F', 'B', 7);
            for (int c = 0; c<8;c++) {
                final var columnId = toBinary(c, 'L', 'R', 3);
                seats.put(rowId,columnId, new Seat(r,c));
            }
        }
        PLANE_SEATS = seats;

    }


    private static String toBinary(int value, char zero, char one, int length) {
        int v = value;
        String result="";
        for (int i = 0; i < length; i++) {
            final char c = v%2==0?zero:one;
            result = c+result;
            v/=2;
        }
        return result;
    }
}
