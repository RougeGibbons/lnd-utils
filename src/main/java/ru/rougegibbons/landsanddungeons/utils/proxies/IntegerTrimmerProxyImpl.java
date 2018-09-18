package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;

/**
 * {@link TrimmerProxyImpl} class extension for {@link Integer} numbers.
 *
 * @see TrimmerProxyImpl
 * @see TrimmerProxy
 * @see ComparatorProxy
 * @see IntegerComparatorProxyImpl
 * @see Integer
 * @since 1.5.8
 */
public class IntegerTrimmerProxyImpl extends TrimmerProxyImpl<Integer>
        implements TrimmerProxy.IntTrimmerProxy {
    private static final ComparatorProxy.IntComparatorProxy COMPARATOR_PROXY =
            new IntegerComparatorProxyImpl();

    /**
     * see {@link TrimmerProxy} description.
     *
     * @return {@link ComparatorProxy.IntComparatorProxy} interface implementation instance.
     */
    @Override
    public @NotNull ComparatorProxy.IntComparatorProxy getComparatorProxy() {
        return COMPARATOR_PROXY;
    }
}
