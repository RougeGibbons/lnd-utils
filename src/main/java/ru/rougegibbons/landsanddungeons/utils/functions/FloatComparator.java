package ru.rougegibbons.landsanddungeons.utils.functions;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class providing proper floating point numbers comparison.
 */
public final class FloatComparator {
    public static final int EQUAL_CODE = 0;
    public static final int LESS_CODE = -1;
    public static final int MORE_CODE = 1;

    private static final int DEFAULT_PRECISION_NUMBERS_COUNT = 4;

    /**
     * compares two floating point numbers
     * and returns comparison sign as digital code.
     *
     * @param lhs - first number to compare.
     * @param rhs - second number to compare.
     * @return 0 if lhs is equal to rhs,
     *    -1 if lhs is less than rhs,
     *    1 if lhs is greater than rhs.
     */
    public static @NotNull Integer compare(@NotNull Float lhs,
                                           @NotNull Float rhs) {
        return new BigDecimal(lhs).setScale(DEFAULT_PRECISION_NUMBERS_COUNT,
                RoundingMode.HALF_UP).compareTo(new BigDecimal(rhs).setScale(
                DEFAULT_PRECISION_NUMBERS_COUNT, RoundingMode.HALF_UP));
    }

    /**
     * compares two floating point numbers and returns true if they are equal.
     *
     * @param lhs - first number to compare.
     * @param rhs - second number to compare.
     * @return true if lhs is equal to lhs digitally or false otherwise.
     */
    public static @NotNull Boolean areEqual(@NotNull Float lhs,
                                            @NotNull Float rhs) {
        return compare(lhs, rhs) == EQUAL_CODE;
    }

    /**
     * compares two floating point numbers and returns true
     * if left hand number is less than right hand one.
     *
     * @param lhs - first number to compare
     * @param rhs - second number to compare
     * @return true if lhs is less than rhs or false otherwise.
     */
    public static @NotNull Boolean isLess(@NotNull Float lhs,
                                          @NotNull Float rhs) {
        return compare(lhs, rhs) == LESS_CODE;
    }

    /**
     * compares two floating point numbers and returns true
     * if left hand number is greater than right hand one.
     *
     * @param lhs - first number to compare.
     * @param rhs - second number to compare.
     * @return true if lhs is greater than rhs or false otherwise.
     */
    public static @NotNull Boolean isGreater(@NotNull Float lhs,
                                             @NotNull Float rhs) {
        return compare(lhs, rhs) == MORE_CODE;
    }
}
