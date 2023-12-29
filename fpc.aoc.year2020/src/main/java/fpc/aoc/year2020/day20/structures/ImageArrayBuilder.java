package fpc.aoc.year2020.day20.structures;

import fpc.aoc.common.AOCException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageArrayBuilder {

  public static @NonNull ImageArray build(@NonNull List<ImageTile> tiles) {
    return ImageArray.with(new ImageArrayBuilder(tiles).build());
  }

  private final List<ImageTile> tiles;
  private int width;
  private Dictionary dictionary;

  private @NonNull List<ImageTile> build() {
    this.buildTileDictionary();
    this.computeFinalImageSize();

    final var image = ImageInProgress.initial(width);
    final Set<Integer> availableIds = tiles.stream().map(ImageTile::id).collect(Collectors.toSet());

    return addNewPiece(image, availableIds).orElseThrow(() -> new AOCException("I'm too stupid to solve this"));

  }

  private void computeFinalImageSize() {
    this.width = (int) Math.round(Math.sqrt(tiles.size()));
  }

  private void buildTileDictionary() {
    this.dictionary = DictionaryBuilder.build(tiles);
  }

  private @NonNull Optional<List<ImageTile>> addNewPiece(@NonNull ImageInProgress image, @NonNull final Set<Integer> availableIds) {
    if (availableIds.isEmpty()) {
      return Optional.of(image.buildResult());
    }

    final Stream<ImageTile> matchingTiles;
    if (image.x == 0 && image.y == 0) {
      matchingTiles = dictionary.allCorners();
    } else if (image.x == 0) {
      matchingTiles = dictionary.findWithUpMatching(image.getReversedLower());
    } else if (image.y == 0) {
      matchingTiles = dictionary.findWithLeftMatching(image.getReversedRight());
    } else {
      matchingTiles = dictionary.findWithLeftAndUpMatching(image.getReversedRight(), image.getReversedLower());
    }

    final Predicate<ImageTile> isAvailable = i -> availableIds.contains(i.id());
    final var candidates = matchingTiles.filter(isAvailable).collect(Collectors.toSet());

    while (true) {
      final ImageTile tested = candidates.stream().findAny().orElse(null);
      if (tested == null) {
        break;
      }
      candidates.remove(tested);
      availableIds.remove(tested.id());
      image.pushTile(tested);
      final var result = addNewPiece(image, availableIds);
      if (result.isPresent()) {
        return result;
      }
      image.popTile();
      availableIds.add(tested.id());
    }
    return Optional.empty();
  }

  @AllArgsConstructor
  private static class ImageInProgress {

    private final List<ImageTile> matchingTiles;
    private final int width;
    private int x;
    private int y;

    public static @NonNull ImageInProgress initial(int width) {
      return new ImageInProgress(new ArrayList<>(width * width), width, 0, 0);
    }

    public @NonNull String getReversedLower() {
      return getImageAt(x, y - 1).reversedLowerBorder();
    }

    public @NonNull String getReversedRight() {
      return getImageAt(x - 1, y).reversedRightBorder();
    }

    public @NonNull ImageTile getImageAt(int x, int y) {
      return matchingTiles.get(x + y * width);
    }

    public void pushTile(@NonNull ImageTile tested) {
      matchingTiles.add(tested);
      this.moveToNextPosition();
    }

    public void popTile() {
      matchingTiles.remove(matchingTiles.size() - 1);
      moveBackToPreviousPosition();
    }

    private void moveBackToPreviousPosition() {
      x = x - 1;
      if (x < 0) {
        y = y - 1;
        x += width;
      }
    }

    private void moveToNextPosition() {
      x = x + 1;
      if (x >= width) {
        y = y + 1;
        x -= width;
      }
    }

    public @NonNull List<ImageTile> buildResult() {
      return List.copyOf(matchingTiles);
    }
  }
}
