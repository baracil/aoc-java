package fpc.aoc.common;

import lombok.NonNull;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.function.ToIntFunction;

public class CodedEnumHelper<E extends Enum<E>> {

    @NonNull
    public static <E extends Enum<E> & Encoded> CodedEnumHelper<E> create(Class<E> enumType)  {
        return new CodedEnumHelper<>(enumType, Encoded::code);
    }

    @NonNull
    private final Class<E> enumType;

    private final E[] valueSortedByCode;

    private final int offset;

    private CodedEnumHelper(Class<E> enumType, ToIntFunction<? super E> codeGetter) {
        this.enumType = enumType;
        final IntSummaryStatistics statistics = Arrays.stream(enumType.getEnumConstants()).mapToInt(codeGetter).summaryStatistics();

        final int size;
        if (statistics.getCount() == 0) {
            size = 0;
            offset = 0;
        }
        else {
            size = 1+ (statistics.getMax() - statistics.getMin());
            offset = statistics.getMin();
        }
        valueSortedByCode = Tools.createArray(enumType, size);

        Arrays.stream(enumType.getEnumConstants()).forEach(e -> valueSortedByCode[codeGetter.applyAsInt(e) - offset] = e);

    }

    @NonNull
    public E get(int code) {
        final E value = valueSortedByCode[code - offset];
        if (value == null) {
            throw new AOCException("Could not find '"+enumType.getSimpleName()+"' with code "+code);
        }
        return value;
    }


}
