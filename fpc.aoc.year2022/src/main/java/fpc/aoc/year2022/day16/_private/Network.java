package fpc.aoc.year2022.day16._private;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Pair;
import fpc.aoc.year2022.day16.Valves;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Network {

  private final Map<String, Integer> rates; //rate of the valve by valve name
  private final Map<String, Set<String>> connections; //connection for each valve


  public @NonNull Valves buildValves() {
    final var names = rates.entrySet()
        .stream()
        .filter(e -> e.getKey().equals("AA") || e.getValue()>0)
        .map(Map.Entry::getKey)
        .sorted()
        .toArray(String[]::new);

    final var rates = new int[names.length];
    final var distances = new int[names.length][names.length];

    for (int i = 0; i < names.length; i++) {
      rates[i] = this.rates.get(names[i]);
      for (int j = i; j < names.length; j++) {
        final var d = distance(names[i], names[j]);
        distances[i][j] = d;
        distances[j][i] = d;
      }
    }

    return new Valves( names, rates, distances);
  }

  public int distance(String start, String end) {
    final Deque<Pair<String,Integer>> toVisit = new LinkedList<>();
    final Set<String> visited = new HashSet<>();

    toVisit.add(Pair.of(start,0));
    visited.add(start);
    do {
      final var p = toVisit.pollFirst();
      if (p == null) {
        throw new AOCException("NOT CONNECTED");
      }
      final var valve = p.first();
      if (valve.equals(end)) {
        return p.second();
      }

      connections.get(valve)
          .stream()
          .filter(v -> !visited.contains(v))
          .forEach(v -> {
              visited.add(v);
              toVisit.add(Pair.of(v,p.second()+1));
      });

    } while (true);
  }


  @Value
  public static class NetworkAggregator {

    public static final Collector<String, ?, Valves> COLLECTOR = Collector.of(
        NetworkAggregator::new,
        NetworkAggregator::addLine,
        NetworkAggregator::combine,
        NetworkAggregator::build
    );

    private static final Pattern PATTERN = Pattern.compile("^Valve (?<name>[A-Z]{2}).*rate=(?<rate>[0-9]+);.*valves? (?<connected>.+)$");

    Map<String, Integer> valves = new HashMap<>();
    Map<String, Set<String>> connections = new HashMap<>();


    public void addLine(@NonNull String line) {
      final var matcher = PATTERN.matcher(line);
      if (!matcher.matches()) {
        throw new AOCException("Cannot parse line '" + line + "'");
      }
      final var name = matcher.group("name");
      final var rate = Integer.parseInt(matcher.group("rate"));
      final var connected = Arrays.stream(matcher.group("connected").split(","))
          .map(String::trim).collect(Collectors.toSet());

      valves.put(name, rate);
      connections.put(name, connected);
    }

    public NetworkAggregator combine(@NonNull Network.NetworkAggregator other) {
      throw new AOCException("Dunno");
    }

    public Valves build() {
      final var network = new Network(valves, connections);
      return network.buildValves();
    }


  }
}
