package fpc.aoc.common;

import lombok.NonNull;

/**
 * @author perococco
 **/
public class NumericalStrings {

    public static int compare(@NonNull String s1, @NonNull String s2) {
        return doCompare(s1, s2);
    }

    private static int doCompare(@NonNull String s1, @NonNull String s2) {
        if (s1.length() > s2.length()) {
            return 1;
        }
        else if (s2.length() > s1.length()) {
            return -1;
        }
        return s1.compareTo(s2);
    }

    @NonNull
    public static String max(@NonNull String s1, @NonNull String s2) {
        final int comparison = compare(s1,s2);
        if (comparison < 0) {
            return s1;
        } else if (comparison > 0) {
            return s2;
        }
        return s1;
    }

    @NonNull
    public static String min(@NonNull String s1, @NonNull String s2) {
        final int comparison = compare(s1,s2);
        if (comparison < 0) {
            return s2;
        } else if (comparison > 0) {
            return s1;
        }
        return s2;
    }

}
