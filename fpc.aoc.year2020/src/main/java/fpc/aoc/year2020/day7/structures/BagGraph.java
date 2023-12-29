package fpc.aoc.year2020.day7.structures;

import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class BagGraph {

    public static final int NOT_SEEN = -2;
    public static final int IN_PROGRESS = -1;

    private final @NonNull Map<String, BagNode> nodes;

    public long countContained(@NonNull String color) {
        return countContained(getBagNode(color), new HashMap<>());
    }

    public long countContainers(@NonNull String color) {
        return countContainers(getBagNode(color), new HashSet<>());
    }


    private int countContained(BagNode bagNode, Map<BagNode, Integer> seen) {
        int count = 0;
        for (var entry : bagNode.getContent().entrySet()) {
            final var contentNode = entry.getKey();
            final var contentQuantity = entry.getValue();

            final int contentCount = countContainedWithCache(contentNode, seen);
            count += (contentCount + 1) * contentQuantity;
        }
        return count;
    }

    private int countContainedWithCache(BagNode bagNode, Map<BagNode, Integer> seen) {
        final int cache = seen.getOrDefault(bagNode, NOT_SEEN);

        if (cache > 0) {
            return cache;
        }

        if (cache == IN_PROGRESS) {
            throw new AOCException("Cycle found '" + bagNode + "'");
        }

        seen.put(bagNode, IN_PROGRESS);
        final var contentCount = countContained(bagNode, seen);
        seen.put(bagNode, contentCount);
        return contentCount;

    }

    private @NonNull long countContainers(@NonNull BagNode node, @NonNull Set<BagNode> seen) {
        long count = 0;
        for (BagNode container : node.getContainers()) {
            if (seen.contains(container)) {
                continue;
            }
            seen.add(container);
            count += 1 + countContainers(container, seen);
        }
        return count;
    }

    private @NonNull BagNode getBagNode(@NonNull String colorName) {
        final BagNode node = nodes.get(colorName);
        if (node == null) {
            throw new AOCException("No bag with color '" + colorName + "'");
        }
        return node;
    }
}
