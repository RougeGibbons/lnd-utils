package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;

/**
 * {@link TrimmerProxyImpl} extension for {@link Float} numbers.
 *
 * @see TrimmerProxy
 * @see TrimmerProxyImpl
 * @see ComparatorProxy
 * @see FloatComparatorProxyImpl
 * @see Float
 * @since 1.5.8
 */
public class FloatTrimmerProxyImpl extends TrimmerProxyImpl<Float>
        implements TrimmerProxy.FloatTrimmerProxy {
    private static final ComparatorProxy.FloatComparatorProxy COMPARATOR_PROXY =
            new FloatComparatorProxyImpl();

    /**
     * see {@link TrimmerProxyImpl} description.
     *
     * @return {@link ComparatorProxy.FloatComparatorProxy} interface implementation instance.
     */
    @Override
    protected @NotNull ComparatorProxy.FloatComparatorProxy getComparatorProxy() {
        return COMPARATOR_PROXY;
    }
}
