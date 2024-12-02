package fpc.aoc.year2019.day8;

import lombok.NonNull;

import java.util.List;
import java.util.stream.IntStream;

public class EncodedLayers {

  private final String code;

  private final int width;

  private final int height;

  private final int layerSize;


  public EncodedLayers(String code, int width, int height) {
    this.code = code;
    this.width = width;
    this.height = height;
    this.layerSize = width * height;
  }

  @NonNull
  public List<Layer> decode() {
    final int nbLayers = code.length() / (width * height);
    return IntStream.range(0, nbLayers)
        .mapToObj(this::createLayer)
        .toList();
  }

  private Layer createLayer(int layerIndex) {
    final int startIndex = layerIndex * layerSize;
    final String layerCode = code.substring(startIndex, startIndex + layerSize);
    return new Layer(convertToPixels(layerCode), width, height);
  }

  @NonNull
  private Pixel[] convertToPixels(String encodeLayer) {
    return encodeLayer.chars().mapToObj(i -> Pixel.get(i - '0')).toArray(Pixel[]::new);
  }

}
