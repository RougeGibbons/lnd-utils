package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;

/**
 * {@link ComparatorProxy} interface implementation for {@link Integer} numbers.
 *
 * @see ComparatorProxy
 * @see Integer
 * @since 1.3.6
 */
public class IntegerComparatorProxyImpl implements ComparatorProxy.IntComparatorProxy {
    /**
     * see {@link ComparatorProxy} description.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs == rhs, false otherwise.
     */
    @Override
    public @NotNull Boolean areEqual(@NotNull Integer lhs,
                                     @NotNull Integer rhs) {
        return lhs.equals(rhs);
    }

    /**
     * see {@link ComparatorProxy} description.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs < rhs, false otherwise.
     */
    @Override
    public @NotNull Boolean isLess(@NotNull Integer lhs,
                                   @NotNull Integer rhs) {
        return lhs < rhs;
    }

    /**
     * see {@link ComparatorProxy} description.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs > rhs, false otherwise
     */
    @Override
    public @NotNull Boolean isGreater(@NotNull Integer lhs,
                                      @NotNull Integer rhs) {
        return lhs > rhs;
    }

    /**
     * see {@link ComparatorProxy} description.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs <= rhs, false otherwise.
     */
    @Override
    public @NotNull Boolean lessOrEqual(@NotNull Integer lhs,
                                        @NotNull Integer rhs) {
        return lhs <= rhs;
    }

    /**
     * see {@link ComparatorProxy} description.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs >= rhs, false otherwise.
     */
    @Override
    public @NotNull Boolean greaterOrEqual(@NotNull Integer lhs,
                                           @NotNull Integer rhs) {
        return lhs >= rhs;
    }
}
