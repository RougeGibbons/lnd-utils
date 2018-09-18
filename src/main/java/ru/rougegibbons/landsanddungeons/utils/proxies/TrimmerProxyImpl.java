package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;

/**
 * generic implementation of {@link TrimmerProxy} interface.
 *
 * @param <T> - any {@link Number} class extensions.
 * @see Number
 * @see TrimmerProxy
 * @see ComparatorProxy
 * @since 1.5.8
 */
public abstract class TrimmerProxyImpl<T extends Number> implements TrimmerProxy<T> {
    /**
     * see {@link TrimmerProxy} description.
     *
     * @param value    - value to trim.
     * @param boundary - minimal allowed value.
     * @return see {@link TrimmerProxy} description.
     */
    @Override
    public @NotNull T trimMin(@NotNull T value,
                              @NotNull T boundary) {
        return getComparatorProxy().greaterOrEqual(value, boundary) ? value : boundary;
    }

    /**
     * see {@link TrimmerProxy} description.
     *
     * @param value    - value to trim.
     * @param boundary - maximal allowed value.
     * @return see {@link TrimmerProxy} description.
     */
    @Override
    public @NotNull T trimMax(@NotNull T value,
                              @NotNull T boundary) {
        return getComparatorProxy().lessOrEqual(value, boundary) ? value : boundary;
    }

    /**
     * see {@link TrimmerProxy} description.
     *
     * @param value         - value to clamp.
     * @param lowerBoundary - minimal allowed value.
     * @param upperBoundary - maximal allowed value.
     * @return see {@link TrimmerProxy} description.
     */
    @Override
    public @NotNull T clamp(@NotNull T value,
                            @NotNull T lowerBoundary,
                            @NotNull T upperBoundary) {
        return trimMax(trimMin(value, lowerBoundary), upperBoundary);
    }

    /**
     * provides access to some {@link ComparatorProxy} interface implementation instance.
     *
     * @return {@link ComparatorProxy} interface implementation instance.
     */
    protected abstract @NotNull ComparatorProxy<T> getComparatorProxy();
}
