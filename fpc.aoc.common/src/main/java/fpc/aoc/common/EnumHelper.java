package fpc.aoc.common;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EnumHelper<K, E extends Enum<E>> {

  @NonNull
  public static <K, E extends Enum<E>> EnumHelper<K, E> create(Class<E> enumType, Function<? super E, ? extends K> keyGetter) {
    return new EnumHelper<>(enumType, keyGetter);
  }

  @NonNull
  private final Class<E> enumType;

  private final Map<K, E> valueById;

  private EnumHelper(Class<E> enumType, Function<? super E, ? extends K> keyGetter) {
    this.enumType = enumType;
    this.valueById = Arrays.stream(enumType.getEnumConstants())
        .collect(Collectors.toMap(keyGetter, Function.identity()));
  }

  @NonNull
  public E get(K code) {
    final E value = valueById.get(code);
    if (value == null) {
      throw new AOCException("Could not find '" + enumType.getSimpleName() + "' with code " + code);
    }
    return value;
  }


}
