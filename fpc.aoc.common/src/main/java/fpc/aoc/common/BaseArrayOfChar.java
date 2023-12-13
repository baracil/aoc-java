package fpc.aoc.common;

import lombok.NonNull;

import java.io.PrintStream;

/**
 * @author Bastien Aracil
 **/
public class BaseArrayOfChar extends BaseArray implements ArrayOfChar {

    @NonNull
    private final char[] data;

    private final char filling;

    private final @NonNull LazyString asString = LazyString.of(this::computeAsString);

    public BaseArrayOfChar(@NonNull char[] data, char filling, int width, int height) {
        super(width, height);
        this.data = data;
        this.filling = filling;
    }

    @Override
    public @NonNull Transformation transformation() {
        return Transformation.IDENTITY;
    }

    @Override
    public char filling() {
        return filling;
    }

    /**
     * @param position the seek position
     * @return the char at the provided position
     */
    public char get(@NonNull Position position) {
        if (isPositionInRange(position)) {
            return data[positionToIndex(position)];
        }
        return filling;
    }

    /**
     * @return the char at x and y
     */
    public char get(int x, int y) {
        if (isInRange(x,y)) {
            return data[xyToIndex(x,y)];
        }
        return filling;
    }

    @Override
    protected void printSingleElement(@NonNull PrintStream printStream, int elementIndex) {
        printStream.print(data[elementIndex]);
    }

    public @NonNull String asString() {
        return asString.toString();
    }


    @Override
    public @NonNull ArrayOfChar rotate(@NonNull Rotation rotation) {
        return new TransformedArrayOfChar(Transformation.of(rotation,Flipping.NONE),this);
    }

    @Override
    public @NonNull ArrayOfChar flip(@NonNull Flipping flipping) {
        return new TransformedArrayOfChar(Transformation.of(Rotation._000,flipping),this);
    }

    @Override
    public @NonNull ArrayOfChar transform(@NonNull Transformation transformation) {
        return new TransformedArrayOfChar(transformation,this);
    }

    @Deprecated
    public void set(int x, int y, char value) {
        this.data[xyToIndex(x,y)] = value;
    }

//    @Deprecated
//    public void setWith(int destX, int destY, @NonNull BaseArrayOfChar other, int srcX, int srcY, int lengthX, int lengthY) {
//        for (int x = 0,dx=destX,sx=srcX; x < lengthX; x++,dx++,sx++) {
//            for (int y = 0,dy=destY,sy=srcY; y < lengthY; y++,dy++,sy++) {
//                this.data[xyToIndex(dx,dy)] = other.get(sx,sy);
//            }
//        }
//    }
//
//    public BaseArrayOfChar flip() {
//        final BaseArrayOfChar flipped = new BaseArrayOfChar(data.clone(), filling, width(), height());
//        for (int x = 0; x < flipped.width() ; x++) {
//            for (int y = 0; y < flipped.height(); y++) {
//                flipped.data[xyToIndex(x,y)] = this.get(width()-1-x,y);
//            }
//        }
//        return flipped;
//    }
//
//    public ArrayOfChar rotate90() {
//        final BaseArrayOfChar rotated = new BaseArrayOfChar(data.clone(), filling, height(), width());
//        for (int x = 0; x < rotated.width() ; x++) {
//            for (int y = 0; y < rotated.height(); y++) {
//                rotated.data[xyToIndex(x,y)] = this.get(rotated.height()-1-y, x);
//            }
//        }
//        return rotated;
//    }

    public @NonNull String computeAsString() {
        final int width = width();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (i != 0 && (i%width) == 0) {
                sb.append('\n');
            }
            sb.append(data[i]);
        }
        return sb.toString();
    }

//    @Override
//    public void setWith(int destX, int destY, @NonNull ArrayOfChar other, int srcX, int srcY, int lengthX, int lengthY) {
//        Tools.TODO();
//    }
//
//    @Override
//    public @NonNull ArrayOfChar rotate(@NonNull Rotation rotation) {
//        return Tools.TODO();
//    }
//
//    @Override
//    public @NonNull ArrayOfChar flip(@NonNull Flipping axis) {
//        return Tools.TODO();
//    }


    @Override
    public String toString() {
        return asString();
    }
}
