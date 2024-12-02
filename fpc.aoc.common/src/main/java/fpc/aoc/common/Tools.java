package fpc.aoc.common;

import lombok.NonNull;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tools {

  public static int toInt(long value) {
    return (int)value;
  }


  public static IntStream generateWithNumberOfBitsAtOne(int nbBits, int nbOnes) {
    if (nbBits < nbOnes) {
      throw new AOCException("Invalid arguments, nbBits must be greater or equal to nbOnes nbBits=" + nbBits + " , nbOnes=" + nbOnes);
    }
    if (nbBits == nbOnes) {
      return IntStream.of((1 << (nbBits + 1)) - 1);
    }
    if (nbOnes == 0) {
      return IntStream.of(0);
    }
    return IntStream.concat(
        generateWithNumberOfBitsAtOne(nbBits - 1, nbOnes).map(i -> i * 2),
        generateWithNumberOfBitsAtOne(nbBits - 1, nbOnes - 1).map(i -> i * 2 + 1)
    );
  }

  public static long longProduct(long l1, long l2) {
    return l1 * l2;
  }

  public static String reverse(String string) {
    return new StringBuilder(string).reverse().toString();
  }

  public static <T> T TODO() {
    throw new AOCException("TO IMPLEMENT");
  }

  public static int sumUpTo(int value) {
    return value * (value + 1) / 2;
  }


  public static <E> List<E> sort(List<E> source, Comparator<? super E> comparator) {
    return source.stream().sorted(comparator).toList();
  }

  public static <E> List<E> sortInPlace(List<E> source, Comparator<? super E> comparator) {
    source.sort(comparator);
    return source;
  }

  public static <E> E getOneElement(Collection<E> collection) {
    return collection.iterator().next();
  }

  @SuppressWarnings("unchecked")
  public static <E> E[] createArray(Class<E> elementType, int size) {
    return (E[]) Array.newInstance(elementType, size);
  }

  public static <T> List<T> replaceAt(List<T> source, int index, Function<? super T, ? extends T> transformer) {
    final List<T> code = new ArrayList<>(source.size());

    if (index > 0) {
      code.addAll(source.subList(0, index));
    }

    final var newValue = transformer.apply(source.get(index));
    code.add(newValue);

    if (index < source.size() - 1) {
      code.addAll(source.subList(index + 1, source.size()));
    }

    return code;
  }

  public static long lcm(long num1, long num2) {
    return (num1 * num2) / gcd(num1, num2);
  }


  public static long gcd(long num1, long num2) {
    if (num2 == 0) {
      return num1;
    }
    return gcd(num2, num1 % num2);
  }

  public static int gcd(int num1, int num2) {
    if (num2 == 0) {
      return num1;
    }
    return gcd(num2, num1 % num2);
  }

  @NonNull
  public static <K, V> Collector<V, ?, Map<K, V>> toMap(Function<? super V, ? extends K> keyGetter) {
    return Collectors.toMap(keyGetter, v -> v);
  }

  public static <K, V> Collector<Pair<K, V>, ?, Map<K, V>> pairsToMap() {
    return Collectors.toMap(Pair::first, Pair::second);
  }


  @NonNull
  public static Optional<Integer> parseInteger(String integer) {
    try {
      return Optional.of(Integer.parseInt(integer));
    } catch (NumberFormatException nfe) {
      return Optional.empty();
    }
  }

  @NonNull
  public static <K, V> Map<K, V> removeKey(Map<K, V> target, K key) {
    if (!target.containsKey(key)) {
      return target;
    }
    return target.entrySet().stream()
        .filter(e -> !e.getKey().equals(key))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  @NonNull
  public static <K, V> Map<K, V> addValue(Map<K, V> target, K key, V value) {
    if (value.equals(target.get(key))) {
      return target;
    }
    final var result = new HashMap<>(target);
    result.put(key, value);
    return result;
  }

  @NonNull
  public static <K> Set<K> addValue(Set<K> target, K value) {
    if (target.contains(value)) {
      return target;
    }
    final var result = new HashSet<>(target);
    result.add(value);
    return result;
  }

  @NonNull
  public static <V> List<V> addValue(List<V> target, V value) {
    final List<V> result = new ArrayList<V>(target.size() + 1);
    result.addAll(target);
    result.add(value);
    return result;
  }

  @SafeVarargs
  @NonNull
  public static <V> List<V> addValues(List<V> target, V... values) {
    final List<V> result = new ArrayList<V>(target.size() + values.length);
    result.addAll(target);
    result.addAll(Arrays.asList(values));
    return result;
  }


  @NonNull
  public static <K, A, B> Map<K, B> mapValues(Map<K, A> input, Function<? super A, ? extends B> mapper) {
    return input
        .entrySet()
        .stream()
        .collect(Collectors.toMap(Map.Entry::getKey, e -> mapper.apply(e.getValue())));
  }


  @NonNull
  public static <A, B> List<B> map(Collection<A> input, Function<? super A, ? extends B> mapper) {
    return input.stream().<B>map(mapper).toList();
  }

  @NonNull
  public static <T> List<T> mergeLists(List<T> firstPart, List<T> secondPart) {
    final List<T> result = new ArrayList<>(firstPart.size() + secondPart.size());
    result.addAll(firstPart);
    result.addAll(secondPart);
    return result;
  }

  @NonNull
  public static <T> Map<T, Integer> mapSmallestIndexInList(List<T> values) {
    final Map<T, Integer> map = new HashMap<>();
    for (int i = 0; i < values.size(); i++) {
      final T value = values.get(i);
      map.merge(value, i, Math::min);
    }
    return map;
  }

  @NonNull
  public static List<String> convertToAscii(String str) {
    return str.chars().mapToObj(Long::toString).toList();
  }

  public static int mod(int value, int base) {
    final int m = value % base;
    return m < 0 ? m + base : m;
  }

  public static int sqrt(int value) {
    return (int) Math.round(Math.sqrt(value));
  }

  public static <E extends Enum<E>> Collector<E, ?, EnumSet<E>> enumSetCollector(Class<E> enumType) {
    return Collector.of(
        () -> EnumSet.noneOf(enumType),
        AbstractCollection::add,
        (e1, e2) -> {
          e1.addAll(e2);
          return e1;
        },
        Collector.Characteristics.IDENTITY_FINISH,
        Collector.Characteristics.UNORDERED
    );
  }

  public static long[] toArrayOfLong(String numbers) {
    return Arrays.stream(numbers.trim().split(" +")).mapToLong(Long::parseLong).toArray();
  }

  public static int[] toArrayOfInt(String numbers) {
    return toArrayOfInt(numbers, " _+");
  }

  public static int[] toArrayOfInt(String numbers, String sep) {
    return Arrays.stream(numbers.trim().split(sep)).mapToInt(Integer::parseInt).toArray();
  }

}
