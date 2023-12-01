package fpc.aoc.common;

import com.google.common.collect.*;
import lombok.NonNull;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;

public class Tools {

    public static long longProduct(long l1, long l2) {
        return l1*l2;
    }

    public static @NonNull String reverse(@NonNull String string) {
            return new StringBuilder(string).reverse().toString();
    }

    public static <T> T TODO() {
        throw new AOCException("TO IMPLEMENT");
    }

    public static int sumUpTo(int value) {
        return value*(value+1)/2;
    }


    public static <E> @NonNull E getOneElement(@NonNull Collection<E> collection) {
        return collection.iterator().next();
    }

    @SuppressWarnings("unchecked")
    public static <E> E[] createArray(@NonNull Class<E> elementType, int size) {
        return (E[]) Array.newInstance(elementType,size);
    }

    public static <T> @NonNull ImmutableList<T> replaceAt(@NonNull ImmutableList<T> source, int index, @NonNull Function<? super T, ? extends T> transformer) {
        final var codeBuilder = ImmutableList.<T>builder();

        if (index > 0) {
            codeBuilder.addAll(source.subList(0, index));
        }

        final var newValue = transformer.apply(source.get(index));
        codeBuilder.add(newValue);

        if (index < source.size() - 1) {
            codeBuilder.addAll(source.subList(index + 1, source.size()));
        }

        return codeBuilder.build();
    }


    @NonNull
    public static <K,V> Collector<V,?,ImmutableMap<K,V>> toImmutableMap(@NonNull Function<? super V, ? extends K> keyGetter) {
        return ImmutableMap.toImmutableMap(keyGetter,v->v);
    }

    public static <K,V> @NonNull Collector<Pair<K,V>,?,ImmutableMap<K,V>> pairsToImmutableMap() {
        return ImmutableMap.toImmutableMap(Pair::first, Pair::second);
    }

    @NonNull
    public static <K,V>Collector<V,?,ImmutableBiMap<K,V>> toImmutableBiMap(@NonNull Function<? super V, ? extends K> keyGetter) {
        return ImmutableBiMap.toImmutableBiMap(keyGetter,v->v);
    }

    @NonNull
    public static Optional<Integer> parseInteger(@NonNull String integer) {
        try {
            return Optional.of(Integer.parseInt(integer));
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }
    }

    @NonNull
    public static <K,V> ImmutableMap<K,V> removeKey(@NonNull ImmutableMap<K,V> target,@NonNull K key) {
        if (!target.containsKey(key)) {
            return target;
        }
        return target.entrySet().stream().filter(e -> !e.getKey().equals(key)).collect(ImmutableMap.toImmutableMap(
                Map.Entry::getKey,
                Map.Entry::getValue));
    }

    @NonNull
    public static <K,V> ImmutableMap<K,V> addValue(@NonNull ImmutableMap<K,V> target,@NonNull K key,@NonNull V value) {
        if (value.equals(target.get(key))) {
            return target;
        }

        final ImmutableMap.Builder<K,V> builder = new ImmutableMap.Builder<>();
        builder.put(key,value);
        target.entrySet()
              .stream()
              .filter(e -> !e.getKey().equals(key))
              .forEach(builder::put);

        return builder.build();
    }

    @NonNull
    public static <K> ImmutableSet<K> addValue(@NonNull ImmutableSet<K> target,@NonNull K value) {
        if (target.contains(value)) {
            return target;
        }
        return ImmutableSet.<K>builder()
                    .addAll(target)
                    .add(value)
                    .build();
    }

    @NonNull
    public static <V> ImmutableList<V> addValue(@NonNull ImmutableList<V> target, @NonNull V value) {
        return ImmutableList.<V>builder().addAll(target).add(value).build();
    }

    @SafeVarargs
    @NonNull
    public static <V> ImmutableList<V> addValues(@NonNull ImmutableList<V> target, @NonNull V... values) {
        return ImmutableList.<V>builder().addAll(target).add(values).build();
    }


    @NonNull
    public static <K,A,B> ImmutableMap<K, B> mapValues(@NonNull ImmutableMap<K,A> input, @NonNull Function<? super A, ? extends B> mapper) {
        return input.entrySet().stream().collect(ImmutableMap.toImmutableMap(Map.Entry::getKey, e -> mapper.apply(e.getValue())));
    }


    @NonNull
    public static <A,B> ImmutableList<B> map(@NonNull ImmutableCollection<A> input, @NonNull Function<? super A, ? extends B> mapper) {
        return input.stream().map(mapper).collect(ImmutableList.toImmutableList());
    }

    @NonNull
    public static <T> ImmutableList<T> mergeLists(@NonNull ImmutableList<T> firstPart,@NonNull ImmutableList<T> secondPart) {
        return ImmutableList.<T>builder().addAll(firstPart).addAll(secondPart).build();
    }

    @NonNull
    public static <T> ImmutableMap<T,Integer> mapSmallestIndexInList(@NonNull ImmutableList<T> values) {
        final Map<T,Integer> map = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            final T value = values.get(i);
            map.merge(value, i, Math::min);
        }
        return ImmutableMap.copyOf(map);
    }

    @NonNull
    public static ImmutableList<String> convertToAscii(@NonNull String str) {
        return str.chars().mapToObj(Long::toString).collect(ImmutableList.toImmutableList());
    }

    public static int mod(int value, int base) {
        final int m = value%base;
        return m<0?m+base:m;
    }

    public static int sqrt(int value) {
        return (int)Math.round(Math.sqrt(value));
    }

    public static <E extends Enum<E>> @NonNull Collector<E,?,EnumSet<E>> enumSetCollector(@NonNull Class<E> enumType) {
        return Collector.of(
                () -> EnumSet.noneOf(enumType),
                AbstractCollection::add,
                (e1,e2) -> {e1.addAll(e2);return e1;},
                Collector.Characteristics.IDENTITY_FINISH,
                Collector.Characteristics.UNORDERED
        );
    }
}
