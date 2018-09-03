package proxies;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.proxies.ComparatorProxy;
import ru.rougegibbons.landsanddungeons.utils.proxies.LongComparatorProxyImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class LongComparatorProxyImplTest {
    @Test
    public void areEqualTest() {
        final ComparatorProxy.LongComparatorProxy proxy = initProxy();
        assertTrue(proxy.areEqual(Constants.ZERO_LONG, Constants.ZERO_LONG),
                "equality expected.");
        assertFalse(proxy.areEqual(Constants.ZERO_LONG, (long) Constants.PERCENTAGE_CAP_INT),
                "non-equality expected.");
    }

    @Test
    public void isLessTest() {
        final ComparatorProxy.LongComparatorProxy proxy = initProxy();
        assertTrue(proxy.isLess((long) Constants.PERCENTAGE_CAP_INT, (long) Constants.WIDE_PERCENTAGE_CAP_INT),
                "less expected.");
        assertFalse(proxy.isLess(Constants.ZERO_LONG, Constants.ZERO_LONG),
                "not less expected.");
        assertFalse(proxy.isLess((long) Constants.WIDE_PERCENTAGE_CAP_INT, (long) Constants.PERCENTAGE_CAP_INT),
                "not less expected");
    }

    @Test
    public void isGreaterTest() {
        final ComparatorProxy.LongComparatorProxy proxy = initProxy();
        assertTrue(proxy.isGreater((long) Constants.WIDE_PERCENTAGE_CAP_INT, (long) Constants.PERCENTAGE_CAP_INT),
                "greater expected.");
        assertFalse(proxy.isGreater(Constants.ZERO_LONG, Constants.ZERO_LONG),
                "not greater expected.");
        assertFalse(proxy.isGreater((long) Constants.PERCENTAGE_CAP_INT, (long) Constants.WIDE_PERCENTAGE_CAP_INT),
                "not greater expected.");
    }

    @Test
    public void lessOrEqualTest() {
        final ComparatorProxy.LongComparatorProxy proxy = initProxy();
        assertTrue(proxy.lessOrEqual(Constants.ZERO_LONG, Constants.ZERO_LONG),
                "equality expected.");
        assertTrue(proxy.lessOrEqual(Constants.ZERO_LONG, (long) Constants.PERCENTAGE_CAP_INT),
                "less expected.");
        assertFalse(proxy.lessOrEqual((long) Constants.PERCENTAGE_CAP_INT, Constants.ZERO_LONG),
                "not less or equal expected.");
    }

    @Test
    public void greaterOrEqualTest() {
        final ComparatorProxy.LongComparatorProxy proxy = initProxy();
        assertTrue(proxy.greaterOrEqual(Constants.ZERO_LONG, Constants.ZERO_LONG),
                "equality expected.");
        assertTrue(proxy.greaterOrEqual((long) Constants.PERCENTAGE_CAP_INT, Constants.ZERO_LONG),
                "greater expected.");
        assertFalse(proxy.greaterOrEqual(Constants.ZERO_LONG, (long) Constants.PERCENTAGE_CAP_INT),
                "not greater or equal expected.");
    }

    private @NotNull ComparatorProxy.LongComparatorProxy initProxy() {
        return new LongComparatorProxyImpl();
    }
}
