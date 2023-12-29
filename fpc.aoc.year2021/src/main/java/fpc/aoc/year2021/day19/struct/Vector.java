package fpc.aoc.year2021.day19.struct;

import lombok.NonNull;

public record Vector(int x, int y, int z) {

    public @NonNull Vector subtract(@NonNull Vector rhs) {
        return new Vector(this.x() - rhs.x(), this.y() - rhs.y(), this.z() - rhs.z());
    }

    public @NonNull Vector add(@NonNull Vector rhs) {
        return new Vector(this.x() + rhs.x(), this.y() + rhs.y(), this.z() + rhs.z());
    }


    public @NonNull Vector rotate(int rotationIdx) {
        return switch (rotationIdx/4) {
            case 0 -> this.rotate2D(rotationIdx);
            case 1 -> new Vector(-this.x, this.y, -this.z).rotate2D(rotationIdx);
            case 2 -> new Vector(this.y,-this.x, this.z).rotate2D(rotationIdx);
            case 3 -> new Vector(-this.y,this.x, this.z).rotate2D(rotationIdx);
            case 4 -> new Vector(this.z, this.y, -this.x).rotate2D(rotationIdx);
            case 5 -> new Vector(-this.z, this.y, this.x).rotate2D(rotationIdx);
            default -> throw new IllegalArgumentException("Invalid rotation");
        };
    }

    private Vector rotate2D(int idx) {
        final var mod = idx%4;
        return switch (mod) {
            case 0 -> this;
            case 1 -> new Vector(this.x, this.z, -this.y);
            case 2 -> new Vector(this.x, -this.y, -this.z);
            case 3 -> new Vector(this.x, -this.z, this.y);
            default -> throw new IllegalArgumentException("Invalid idx "+idx);
        };
    }

    public static @NonNull Vector parse(@NonNull String line) {
        final var tokens = line.split(",");
        return new Vector(
                Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2])
        );
    }


}
