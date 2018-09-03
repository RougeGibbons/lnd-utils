package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;

/**
 * Wrapper interface to do comparisons in generics.
 *
 * @param <T> - any extension of {@link Number} class.
 * @since 1.3.6
 */
public interface ComparatorProxy<T extends Number> {
    /**
     * checks if one number is equal to another.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs == rhs, false otherwise;
     */
    @NotNull Boolean areEqual(@NotNull T lhs, @NotNull T rhs);

    /**
     * checks if one number is lesser than another.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs < rhs, false otherwise.
     */
    @NotNull Boolean isLess(@NotNull T lhs, @NotNull T rhs);

    /**
     * checks if one number is greater than another.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs > rhs, false otherwise.
     */
    @NotNull Boolean isGreater(@NotNull T lhs, @NotNull T rhs);

    /**
     * checks if one number is lesser or equal than another.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs <= rhs, false otherwise.
     */
    @NotNull Boolean lessOrEqual(@NotNull T lhs, @NotNull T rhs);

    /**
     * checks if one number is greater or equal than another.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs >= rhs, false otherwise.
     */
    @NotNull Boolean greaterOrEqual(@NotNull T lhs, @NotNull T rhs);

    interface IntComparatorProxy extends ComparatorProxy<Integer> {

    }

    interface LongComparatorProxy extends ComparatorProxy<Long> {

    }

    interface FloatComparatorProxy extends ComparatorProxy<Float> {

    }
}
