package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.landsanddungeons.utils.functions.FloatMath;

/**
 * Wrapper class to do arithmetic operations in generics.
 *
 * @param <T> - any extension of {@link Number} class.
 * @see Number
 * @since 1.2.5
 */
public interface ArithmeticsProxy<T extends Number> {
    /**
     * adds lhs to rhs and returns the summ.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs + rhs.
     */
    @NotNull T add(@NotNull T lhs, @NotNull T rhs);

    /**
     * subtracts rhs from lhs and returns the difference.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs - rhs.
     */
    @NotNull T subtract(@NotNull T lhs, @NotNull T rhs);

    /**
     * multiplies lhs by rhs and returns the result.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs * rhs
     */
    @NotNull T multiply(@NotNull T lhs, @NotNull T rhs);

    /**
     * divides lhs by rhs and returns the result.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs / rhs.
     */
    @NotNull T divide(@NotNull T lhs, @NotNull T rhs);

    /**
     * modifies source value by given percent.
     *
     * @param source  - initial value.
     * @param percent - percentage.
     * @return modified value.
     * @since 1.4.7
     */
    default @NotNull T modifyByPercentage(@NotNull T source,
                                          @NotNull Integer percent) {
        return modifyByPercentage(source, FloatMath.toPercent(percent));
    }

    /**
     * modifies source value by given percent.
     *
     * @param source  - initial value.
     * @param percent - percentage.
     * @return modified value.
     * @since 1.4.7
     */
    @NotNull T modifyByPercentage(@NotNull T source,
                                  @NotNull Float percent);

    interface IntArithmeticsProxy extends ArithmeticsProxy<Integer> {

    }

    interface LongArithmeticsProxy extends ArithmeticsProxy<Long> {

    }

    interface FloatArithmeticsProxy extends ArithmeticsProxy<Float> {

    }
}
