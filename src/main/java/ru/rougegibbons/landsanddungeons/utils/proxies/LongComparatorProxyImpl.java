package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;

/**
 * {@link ComparatorProxy} interface implementation for {@link Long} numbers.
 *
 * @see ComparatorProxy
 * @see Long
 * @since 1.3.6
 */
public class LongComparatorProxyImpl implements ComparatorProxy.LongComparatorProxy {
    /**
     * see {@link ComparatorProxy} description.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs == rhs, false otherwise.
     */
    @Override
    public @NotNull Boolean areEqual(@NotNull Long lhs,
                                     @NotNull Long rhs) {
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
    public @NotNull Boolean isLess(@NotNull Long lhs,
                                   @NotNull Long rhs) {
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
    public @NotNull Boolean isGreater(@NotNull Long lhs,
                                      @NotNull Long rhs) {
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
    public @NotNull Boolean lessOrEqual(@NotNull Long lhs,
                                        @NotNull Long rhs) {
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
    public @NotNull Boolean greaterOrEqual(@NotNull Long lhs,
                                           @NotNull Long rhs) {
        return lhs >= rhs;
    }
}
