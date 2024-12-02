package fpc.aoc.year2019.day17._private;

import fpc.aoc.common.Position;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Picture {

  @NonNull
  public static Picture withRobot(List<Pixel> pixels, int width, int height, Position robotPosition) {
    return new Picture(pixels, width, height, robotPosition);
  }

  @NonNull
  public static Picture withoutRobot(List<Pixel> pixels, int width, int height) {
    return new Picture(pixels, width, height, null);
  }


  @NonNull
  private final List<Pixel> pixels;

  @Getter
  private final int width;

  @Getter
  private final int height;

  private final Position vacuumPosition;

  @NonNull
  public Optional<Position> getVacuumPosition() {
    return Optional.ofNullable(vacuumPosition);
  }

  public boolean isScaffoldPresentAt(Position position) {
    return pixelAt(position).scaffold();
  }

  @NonNull
  public Stream<Position> scaffoldNextTo(Position position) {
    return position.neighbourStream().filter(this::isScaffoldPresentAt);
  }

  @NonNull
  public Stream<Position> allScaffoldPositions() {
    return IntStream.range(0, height * width)
        .mapToObj(i -> Position.of(i % width, i / width))
        .filter(this::isScaffoldPresentAt);
  }

  public void print() {
    print(System.out);
  }

  public void print(PrintStream printStream) {
    int x = 0;
    for (Pixel pixel : pixels) {
      System.out.print(pixel.representation());
      x++;
      if ((x % width) == 0) {
        printStream.println();
      }
    }
  }

  @NonNull
  public Pixel pixelAt(Position position) {
    final int x = position.x();
    final int y = position.y();
    final int pos = x + y * width;
    if (x < 0 || y < 0 || pos >= pixels.size()) {
      return Pixel.SPACE;
    }
    return pixels.get(pos);
  }


  @NonNull
  public static Builder builder() {
    return new Builder();
  }


  @NonNull
  public static Collector<String, ?, Picture> collector() {
    return Collector.of(Picture::builder,
        Builder::appendData,
        (b1, b2) -> {
          throw new RuntimeException("Cannot combine picture builders");
        },
        Builder::build
    );
  }


  public static class Builder {

    private int vacuumIdx = -1;

    private int idx = 0;

    private int y = 0;

    private int height = 0;

    private final List<Pixel> builder = new ArrayList<>();

    public Builder appendData(String data) {
      if ("10".equals(data)) {
        y++;
      } else {
        height = y + 1;
        final Pixel pixel = Pixel.decode(data);
        if (pixel.isRobot()) {
          vacuumIdx = idx;
        }
        builder.add(Pixel.decode(data));
        idx++;
      }
      return this;
    }

    @NonNull
    public Picture build() {
      final List<Pixel> pixels = new ArrayList<>(builder);
      final int width = pixels.size() / height;

      if (vacuumIdx < 0) {
        return Picture.withoutRobot(pixels, width, height);
      } else {
        return Picture.withRobot(pixels, width, height, Position.of(vacuumIdx % width, vacuumIdx / width));
      }
    }
  }
}
