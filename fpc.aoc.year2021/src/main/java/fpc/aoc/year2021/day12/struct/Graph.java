package fpc.aoc.year2021.day12.struct;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Graph {

    @Getter
    private final Node start;

    private final Map<Node, List<Node>> connections;





    public static Collector<Connection,?,Graph> COLLECTOR = Collector.of(
            GraphCollector::new,
            GraphCollector::pushConnection,
            GraphCollector::combine,
            GraphCollector::build
    );

    public @NonNull List<Node> getConnections(@NonNull Node position) {
        return connections.getOrDefault(position,List.of());
    }


    private static class GraphCollector {

        private Node start = null;

        private final Map<Node,List<Node>> connections = new HashMap<>();

        private @NonNull Graph build() {
            return new Graph(start,connections.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        }

        private void pushConnection(@NonNull Connection connection) {
            final var node1 = connection.node1();
            final var node2 = connection.node2();

            if (node1.start()) {
                this.start = node1;
            }
            if (node2.start()) {
                this.start = node2;
            }

            this.connections.computeIfAbsent(node1, n -> new ArrayList<>()).add(node2);
            this.connections.computeIfAbsent(node2, n -> new ArrayList<>()).add(node1);
        }

        public @NonNull GraphCollector combine(@NonNull GraphCollector a2) {
            if (a2.start != null) {
                this.start = a2.start;
            }

            a2.connections.forEach((node,connection) -> this.connections.computeIfAbsent(node, n -> new ArrayList<>()).addAll(connection));
            return this;
        }
    }
}
