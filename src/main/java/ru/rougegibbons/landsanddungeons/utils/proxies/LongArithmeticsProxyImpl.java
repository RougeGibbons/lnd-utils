package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.functions.FloatMath;

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

    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param source  - initial value.
     * @param percent - percentage.
     * @return modified value.
     */
    @Override
    public @NotNull Long modifyByPercentage(@NotNull Long source,
                                            @NotNull Float percent) {
        return FloatMath.multiply(source.floatValue(),
                Constants.PERCENTAGE_CAP_FLOAT + percent).longValue();
    }
}
