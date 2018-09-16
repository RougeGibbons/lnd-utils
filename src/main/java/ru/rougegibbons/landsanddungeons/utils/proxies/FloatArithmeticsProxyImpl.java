package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.functions.FloatMath;

public class FloatArithmeticsProxyImpl implements ArithmeticsProxy.FloatArithmeticsProxy {
    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs + rhs.
     */
    @Override
    public @NotNull Float add(@NotNull Float lhs,
                              @NotNull Float rhs) {
        return FloatMath.add(lhs, rhs);
    }

    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs - rhs.
     */
    @Override
    public @NotNull Float subtract(@NotNull Float lhs,
                                   @NotNull Float rhs) {
        return FloatMath.subtract(lhs, rhs);
    }

    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs * rhs.
     */
    @Override
    public @NotNull Float multiply(@NotNull Float lhs,
                                   @NotNull Float rhs) {
        return FloatMath.multiply(lhs, rhs);
    }

    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param lhs - first value.
     * @param rhs - second value.
     * @return lhs / rhs.
     */
    @Override
    public @NotNull Float divide(@NotNull Float lhs,
                                 @NotNull Float rhs) {
        return FloatMath.divide(lhs, rhs);
    }

    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param source  - initial value.
     * @param percent - percentage.
     * @return modified value.
     */
    @Override
    public @NotNull Float modifyByPercentage(@NotNull Float source,
                                             @NotNull Float percent) {
        return FloatMath.multiply(source,
                Constants.PERCENTAGE_CAP_FLOAT + percent);
    }
}
