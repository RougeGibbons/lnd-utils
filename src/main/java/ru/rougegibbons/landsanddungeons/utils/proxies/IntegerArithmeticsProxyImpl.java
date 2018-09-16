package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.functions.FloatMath;

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

    /**
     * see {@link ArithmeticsProxy}.
     *
     * @param source  - initial value.
     * @param percent - percentage.
     * @return modified value.
     */
    @Override
    public @NotNull Integer modifyByPercentage(@NotNull Integer source,
                                               @NotNull Float percent) {
        return FloatMath.multiply(source.floatValue(),
                Constants.PERCENTAGE_CAP_FLOAT + percent).intValue();
    }
}
