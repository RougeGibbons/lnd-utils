package ru.rougegibbons.landsanddungeons.utils.proxies;

import org.jetbrains.annotations.NotNull;

/**
 * {@link TrimmerProxyImpl} extension for {@link Long} numbers.
 *
 * @see TrimmerProxy
 * @see TrimmerProxy
 * @see ComparatorProxy
 * @see LongComparatorProxyImpl
 * @see Long
 * @since 1.5.8
 */
public class LongTrimmerProxyImpl extends TrimmerProxyImpl<Long>
        implements TrimmerProxy.LongTrimmerProxy {
    private static final ComparatorProxy.LongComparatorProxy COMPARATOR_PROXY =
            new LongComparatorProxyImpl();

    /**
     * see {@link TrimmerProxyImpl} description.
     *
     * @return {@link ComparatorProxy.LongComparatorProxy} interface implementation instance.
     */
    @Override
    protected @NotNull ComparatorProxy.LongComparatorProxy getComparatorProxy() {
        return COMPARATOR_PROXY;
    }
}
