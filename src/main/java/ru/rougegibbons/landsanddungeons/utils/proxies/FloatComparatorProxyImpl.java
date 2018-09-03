package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.landsanddungeons.utils.functions.FloatComparator;

/**
 * {@link ComparatorProxy} interface implementation for {@link Float} numbers.
 *
 * @see ComparatorProxy
 * @see Float
 * @see FloatComparator
 * @since 1.3.6
 */
public class FloatComparatorProxyImpl implements ComparatorProxy.FloatComparatorProxy {
    /**
     * see {@link ComparatorProxy} description.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs == rhs, false otherwise.
     */
    @Override
    public @NotNull Boolean areEqual(@NotNull Float lhs,
                                     @NotNull Float rhs) {
        return FloatComparator.areEqual(lhs, rhs);
    }

    /**
     * see {@link ComparatorProxy} description.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs < rhs, false otherwise.
     */
    @Override
    public @NotNull Boolean isLess(@NotNull Float lhs,
                                   @NotNull Float rhs) {
        return FloatComparator.isLess(lhs, rhs);
    }

    /**
     * see {@link ComparatorProxy} description.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs > rhs, false otherwise
     */
    @Override
    public @NotNull Boolean isGreater(@NotNull Float lhs,
                                      @NotNull Float rhs) {
        return FloatComparator.isGreater(lhs, rhs);
    }

    /**
     * see {@link ComparatorProxy} description.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs <= rhs, false otherwise.
     */
    @Override
    public @NotNull Boolean lessOrEqual(@NotNull Float lhs,
                                        @NotNull Float rhs) {
        return FloatComparator.isLess(lhs, rhs)
                || FloatComparator.areEqual(lhs, rhs);
    }

    /**
     * see {@link ComparatorProxy} description.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs >= rhs, false otherwise.
     */
    @Override
    public @NotNull Boolean greaterOrEqual(@NotNull Float lhs,
                                           @NotNull Float rhs) {
        return FloatComparator.isGreater(lhs, rhs)
                || FloatComparator.areEqual(lhs, rhs);
    }
}
