package ru.rougegibbons.landsanddungeons.utils.functions;

import org.jetbrains.annotations.NotNull;

/**
 * Class contains different math utils
 * useful for processing integer
 * and float digits data.
 */
public final class MathUtils {
    /**
     * clamps passed value between given boundaries.
     *
     * @param value - value to be estimated
     * @param min   - lower boundary
     * @param max   - upper boundary
     * @return value if it is in [min; max] range, min
     *  if value is lower than min or max if value is bigger than max.
     */
    public static @NotNull Integer clamp(@NotNull Integer value,
                                         @NotNull Integer min,
                                         @NotNull Integer max) {
        return trimMin(trimMax(value, max), min);
    }


    /**
     * clamps passed value between given boundaries
     *
     * @param value - value to be estimated
     * @param min   - lower boundary
     * @param max   - upper boundary
     * @return value if it is in [min; max] range, min
     *  if value is lower than min or max if value is bigger than max.
     */
    public static @NotNull Float clamp(@NotNull Float value,
                                       @NotNull Float min,
                                       @NotNull Float max) {
        return trimMin(trimMax(value, max), min);
    }

    /**
     * compares input value with given boundary
     * and returns either value or boundary.
     *
     * @param value - value to be compared
     * @param min   - boundary to compare with
     * @return value if it is bigger or equal to min, or min otherwise.
     */
    public static @NotNull Integer trimMin(@NotNull Integer value,
                                           @NotNull Integer min) {
        return value < min ? min : value;
    }

    /**
     * compares input value with given boundary
     * and returns either value or boundary.
     *
     * @param value - value to be compared
     * @param min   - boundary to compare with
     * @return value if it is bigger or equal to min, or min otherwise.
     */
    public static @NotNull Float trimMin(@NotNull Float value,
                                         @NotNull Float min) {
        return FloatComparator.isLess(value, min) ? min : value;
    }

    /**
     * compares input value with given boundary
     * and returns either value or boundary.
     *
     * @param value - value to be compared
     * @param max   - value to compare with
     * @return value if it is smaller or equal to max, or max otherwise.
     */
    public static @NotNull Integer trimMax(@NotNull Integer value,
                                           @NotNull Integer max) {
        return value > max ? max : value;
    }

    /**
     * compares input value with given boundary
     * and returns either value or boundary.
     *
     * @param value - value to be compared
     * @param max   - value to compare with
     * @return value if it is smaller or equal to max, or max otherwise.
     */
    public static @NotNull Float trimMax(@NotNull Float value,
                                         @NotNull Float max) {
        return FloatComparator.isGreater(value, max) ? max : value;
    }
}
