package fpc.aoc.year2020.day7.structures;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
@EqualsAndHashCode(of = {"color"})
public class BagNode {

    @Getter
    private final @NonNull String color;

    private final @NonNull Set<BagNode> containers = new HashSet<>();

    private final @NonNull Map<BagNode,Integer> content = new HashMap<>();

    public void addToContent(@NonNull BagNode contained, int quantity) {
        content.put(contained,quantity);
        contained.containers.add(this);
    }

    public @NonNull Map<BagNode,Integer> getContent() {
        return Collections.unmodifiableMap(content);
    }

    public @NonNull Set<BagNode> getContainers() {
        return containers;
    }

}
