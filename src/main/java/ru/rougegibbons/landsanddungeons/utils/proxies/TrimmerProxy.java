package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;

/**
 * Interface for generified number trimming operations.
 *
 * @param <T> - any {@link Number} class extension.
 * @see Number
 * @since 1.5.8
 */
public interface TrimmerProxy<T extends Number> {
    /**
     * compares given value with given boundary and returns value if it is greater or equal to the boundary.
     *
     * @param value    - value to trim.
     * @param boundary - minimal allowed value.
     * @return value if value >= boundary or boundary otherwise.
     */
    @NotNull T trimMin(@NotNull T value,
                       @NotNull T boundary);

    /**
     * compares given value with given boundary and returns value if it is less or equal to the boundary.
     *
     * @param value    - value to trim.
     * @param boundary - maximal allowed value.
     * @return value if value <= boundary or boundary otherwise.
     */
    @NotNull T trimMax(@NotNull T value,
                       @NotNull T boundary);

    /**
     * compares given value with given boundaries and returns value if it is in [lowerBoundary; upperBoundary] range.
     *
     * @param value         - value to clamp.
     * @param lowerBoundary - minimal allowed value.
     * @param upperBoundary - maximal allowed value.
     * @return value if it is in [lowerBoundary; upperBoundary] range or one of the boundaries.
     */
    @NotNull T clamp(@NotNull T value,
                     @NotNull T lowerBoundary,
                     @NotNull T upperBoundary);

    /**
     * provides access to some {@link ComparatorProxy} interface implementation instance.
     *
     * @return {@link ComparatorProxy} interface implementation instance.
     * @since 1.5.9
     */
    @NotNull ComparatorProxy<T> getComparatorProxy();

    interface IntTrimmerProxy extends TrimmerProxy<Integer> {

    }

    interface LongTrimmerProxy extends TrimmerProxy<Long> {

    }

    interface FloatTrimmerProxy extends TrimmerProxy<Float> {

    }
}
