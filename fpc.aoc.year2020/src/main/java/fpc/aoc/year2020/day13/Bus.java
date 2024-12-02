package fpc.aoc.year2020.day13;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.Optional;


@Getter
@RequiredArgsConstructor
public class Bus {

  public static Bus parse(String idAsString) {
    if (idAsString.equals("x")) {
      return new Bus(BigInteger.ZERO);
    } else {
      return new Bus(BigInteger.valueOf(Long.parseLong(idAsString)));
    }
  }

  private final BigInteger id;

  public boolean isOutOfService() {
    return id.equals(BigInteger.ZERO);
  }

  public boolean isRunning() {
    return !isOutOfService();
  }

  public Optional<NextStop> findNextStop(BigInteger instant) {
    if (isOutOfService()) {
      return Optional.empty();
    }
    final var mod = instant.mod(id);
    if (mod.equals(BigInteger.ZERO)) {
      return Optional.of(new NextStop(this, mod));
    }
    return Optional.of(new NextStop(this, id.subtract(mod)));
  }
}
