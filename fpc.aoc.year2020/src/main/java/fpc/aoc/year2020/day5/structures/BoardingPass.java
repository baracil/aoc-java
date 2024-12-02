package fpc.aoc.year2020.day5.structures;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class BoardingPass {

  public static BoardingPass create(String code) {
    final Seat seat = Seat.of(code);
    return new BoardingPass(code, seat);
  }

  String code;

  Seat seat;

  public int getSeatId() {
    return seat.id();
  }

}
