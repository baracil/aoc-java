package fpc.aoc.year2020.day20.structures;

import fpc.aoc.common.ArrayOfChar;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Parser {

  public static List<ImageTile> parse(List<String> lines) {
    return new Parser(lines).parse();
  }

  private final List<String> lines;

  private final List<ImageTile> tileListBuilder = new ArrayList<>();
  private ImageTileBuilder imageTileBuilder;

  private List<ImageTile> parse() {
    this.initializeImageTileBuilder();
    for (String line : lines) {
      if (line.isBlank()) {
        this.addImageTileInProgressToListOfTiles();
      } else if (line.startsWith("Tile ")) {
        this.initializeImageTileBuilder();
        this.parseImageTileId(line);
      } else {
        this.parseDataLine(line);
      }
    }
    this.addImageTileInProgressToListOfTiles();
    return tileListBuilder;
  }

  private void addImageTileInProgressToListOfTiles() {
    if (this.imageTileBuilder != null) {
      this.tileListBuilder.add(this.imageTileBuilder.build());
    }
    this.imageTileBuilder = null;
  }

  private void initializeImageTileBuilder() {
    this.imageTileBuilder = new ImageTileBuilder();
  }

  private void parseImageTileId(String line) {
    final int id = Integer.parseInt(line.substring("Tile ".length(), line.length() - 1));
    imageTileBuilder.id(id);
  }

  private void parseDataLine(String line) {
    imageTileBuilder.datum(line);
  }


  private static class ImageTileBuilder {

    private Integer id;
    private final List<String> data = new ArrayList<>();

    public void id(int id) {
      this.id = id;
    }

    public void datum(String line) {
      this.data.add(line);
    }

    public ImageTile build() {
      return new ImageTile(id, ArrayOfChar.from(data, '.'));
    }
  }
}
