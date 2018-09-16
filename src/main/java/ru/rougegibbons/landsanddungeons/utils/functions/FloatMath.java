package ru.rougegibbons.landsanddungeons.utils.functions;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class containing basic float point arithmetic:
 * addition, subtraction, multiplication, division.
 * Default precision clamps floating points number to fixed value.
 */
public final class FloatMath {
    private static final int FLOAT_MATH_PRECISION = 4;

    /**
     * adds one number to another and returns summ value.
     *
     * @param lhs - first number
     * @param rhs - second number
     * @return lhs + rhs
     */
    // CHECKSTYLE:OFF
    public static @NotNull Float add(@NotNull Float lhs,
                                     @NotNull Float rhs) {
        return new BigDecimal(lhs).setScale(FLOAT_MATH_PRECISION,
                RoundingMode.HALF_UP).add(new BigDecimal(rhs).setScale(
                FLOAT_MATH_PRECISION, RoundingMode.HALF_UP)).floatValue();
    }
    // CHECKSTYLE:ON

    /**
     * subtracts second number from first one and returns the difference.
     *
     * @param lhs - minuend
     * @param rhs - subtrahend
     * @return lhs - rhs
     */
    public static @NotNull Float subtract(@NotNull Float lhs,
                                          @NotNull Float rhs) {
        return new BigDecimal(lhs).setScale(FLOAT_MATH_PRECISION,
                RoundingMode.HALF_UP).subtract(new BigDecimal(rhs).setScale(
                FLOAT_MATH_PRECISION, RoundingMode.HALF_UP)).floatValue();
    }

    /**
     * multiplies one value by another and returns the result.
     *
     * @param lhs - first value
     * @param rhs - second value
     * @return lhs * rhs
     */
    public static @NotNull Float multiply(@NotNull Float lhs,
                                          @NotNull Float rhs) {
        return new BigDecimal(lhs).setScale(FLOAT_MATH_PRECISION,
                RoundingMode.HALF_UP).multiply(new BigDecimal(rhs).setScale(
                FLOAT_MATH_PRECISION, RoundingMode.HALF_UP)).floatValue();
    }

    /**
     * divides first value by second and returns the result.
     *
     * @param lhs - dividend
     * @param rhs - divisor
     * @return lhs / rhs
     */
    public static @NotNull Float divide(@NotNull Float lhs,
                                        @NotNull Float rhs) {
        return new BigDecimal(lhs).setScale(FLOAT_MATH_PRECISION,
                RoundingMode.HALF_UP).divide(new BigDecimal(rhs).setScale(
                FLOAT_MATH_PRECISION, RoundingMode.HALF_UP),
                FLOAT_MATH_PRECISION, RoundingMode.HALF_UP).floatValue();
    }

    /**
     * converts {@link Integer} percent value to {@link Float} representation.
     *
     * @param percent - {@link Integer} percentage.
     * @return {@link Float} percentage.
     * @since 1.4.7
     */
    public static @NotNull Float toPercent(@NotNull Integer percent) {
        return divide(percent.floatValue(), (float) Constants.PERCENTAGE_CAP_INT);
    }
}
