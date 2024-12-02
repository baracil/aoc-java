package fpc.aoc.year2019.day8;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Layer {

    @NonNull
    private final Pixel[] pixels;

    private final int width;

    private final int height;

    private final Map<Pixel,Integer> counts;

    public Layer(Pixel[] pixels, int width, int height) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;

        this.counts = Arrays.stream(pixels)
                            .collect(Collectors.groupingBy(d -> d, Collectors.summingInt(d -> 1)));
    }

    @NonNull
    public Stream<String> lines() {
        return IntStream.range(0,height).mapToObj(this::editOneRow);
    }

    @NonNull
    private String editOneRow(int rowIndex) {
        final int offset = rowIndex*width;
        return Arrays.stream(pixels,offset,offset+width)
                     .map(Pixel::representation)
                     .collect(Collectors.joining());

    }

    public int numberOf(Pixel pixel) {
        return counts.getOrDefault(pixel, 0);
    }

    public int numberOfZeroDigit() {
        return numberOf(Pixel.D0_BLACK);
    }

    @NonNull
    public Layer stack(Layer below) {
        final Pixel[] result = new Pixel[this.pixels.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = this.pixels[i].stack(below.pixels[i]);
        }

        return new Layer(result,width,height);
    }
}
