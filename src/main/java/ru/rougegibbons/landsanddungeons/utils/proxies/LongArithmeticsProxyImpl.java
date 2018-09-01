package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;

public class LongArithmeticsProxyImpl implements ArithmeticsProxy.LongArithmeticsProxy {
    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs + rhs.
     */
    @Override
    public @NotNull Long add(@NotNull Long lhs,
                             @NotNull Long rhs) {
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
    public @NotNull Long subtract(@NotNull Long lhs,
                                  @NotNull Long rhs) {
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
    public @NotNull Long multiply(@NotNull Long lhs,
                                  @NotNull Long rhs) {
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
    public @NotNull Long divide(@NotNull Long lhs,
                                @NotNull Long rhs) {
        return lhs / rhs;
    }
}
