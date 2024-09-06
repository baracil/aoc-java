package fpc.aoc.year2019.day10.computation;

import fpc.aoc.common.Tools;
import lombok.NonNull;
import lombok.Value;

import java.util.Comparator;

@Value
public class RadialRelativePosition {

    public static Comparator<RadialRelativePosition> COMPARE_RADIUS = Comparator.comparingInt(RadialRelativePosition::radius);

    @NonNull
    public static RadialRelativePosition create(int dx, int dy) {
        final int radius = Tools.gcd(Math.abs(dx),Math.abs(dy));
        return new RadialRelativePosition(radius,Direction.create(dx,dy));
   }


    int radius;

    @NonNull Direction direction;

    public boolean isNotNil() {
        return radius != 0;
    }

    @NonNull
    public Position add(@NonNull Position reference) {
        return Position.create(
                reference.x()+radius*direction.dx(),
                reference.y()+radius*direction.dy()
        );
    }
}
