package fpc.aoc.year2019.day18._private.algo;

import fpc.aoc.year2019.day18._private.Door;
import fpc.aoc.year2019.day18._private.Key;
import fpc.aoc.year2019.day18._private.Keyring;
import lombok.*;

import java.util.List;
import java.util.Set;

/**
 * A route between to key (forming a trip). A route is oriented (it has a start and an end). The orientation
 * is necessary because of possible doors on the route that might be opened while traveling the route.
 *
 * By construction, the doors on this route that might be opened while traveling
 * on this route are not listed in the {@link #doorsOnTheWay} set.
 *
 */
@RequiredArgsConstructor
@Builder(builderClassName = "Builder")
public class Route {

    @NonNull
    @Getter
    private final Trip trip;

    @Getter
    private final int length;

    @NonNull
    @Singular
    private final List<Key> intermediaryKeys;

    @NonNull
    @Singular(value = "doorOnTheWay")
    private final Set<Door> doorsOnTheWay;

    public boolean isNotBlocked(@NonNull Keyring keyring) {
        return keyring.canOpen(doorsOnTheWay);
    }

    @NonNull
    public Key start() {
        return trip.from();
    }

    @NonNull
    public Key destination() {
        return trip.to();
    }

    public boolean allIntermediaryKeysHaveBeenObtained(@NonNull Keyring keyring) {
        return keyring.areAlreadyObtained(intermediaryKeys);
    }
}
