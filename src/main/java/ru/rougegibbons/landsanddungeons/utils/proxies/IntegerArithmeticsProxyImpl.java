package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;

/**
 * {@link ArithmeticsProxy} interface implementation for {@link Integer} numbers.
 *
 * @see ArithmeticsProxy
 * @see Integer
 * @since 1.2.5
 */
public class IntegerArithmeticsProxyImpl implements ArithmeticsProxy.IntArithmeticsProxy {
    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs + rhs.
     */
    @Override
    public @NotNull Integer add(@NotNull Integer lhs,
                                @NotNull Integer rhs) {
        return lhs + rhs;
    }

    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs - rhs.
     */
    @Override
    public @NotNull Integer subtract(@NotNull Integer lhs,
                                     @NotNull Integer rhs) {
        return lhs - rhs;
    }

    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs * rhs.
     */
    @Override
    public @NotNull Integer multiply(@NotNull Integer lhs,
                                     @NotNull Integer rhs) {
        return lhs * rhs;
    }

    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs / rhs.
     */
    @Override
    public @NotNull Integer divide(@NotNull Integer lhs,
                                   @NotNull Integer rhs) {
        return lhs / rhs;
    }
}
