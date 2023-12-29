package fpc.aoc.year2020.day5.structures;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class BoardingPass {

  public static BoardingPass create(@NonNull String code) {
    final Seat seat = Seat.of(code);
    return new BoardingPass(code, seat);
  }

  @NonNull String code;

  @NonNull Seat seat;

  public int getSeatId() {
    return seat.id();
  }

}
