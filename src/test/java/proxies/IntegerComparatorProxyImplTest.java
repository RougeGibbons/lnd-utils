package proxies;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.proxies.ComparatorProxy;
import ru.rougegibbons.landsanddungeons.utils.proxies.IntegerComparatorProxyImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class IntegerComparatorProxyImplTest {
    @Test
    public void areEqualTest() {
        final ComparatorProxy.IntComparatorProxy proxy = initProxy();
        assertTrue(proxy.areEqual(Constants.ZERO_INT, Constants.ZERO_INT),
                "equality expected.");
        assertFalse(proxy.areEqual(Constants.ZERO_INT, Constants.PERCENTAGE_CAP_INT),
                "non-equality expected.");
    }

    @Test
    public void isLessTest() {
        final ComparatorProxy.IntComparatorProxy proxy = initProxy();
        assertTrue(proxy.isLess(Constants.PERCENTAGE_CAP_INT, Constants.WIDE_PERCENTAGE_CAP_INT),
                "less expected.");
        assertFalse(proxy.isLess(Constants.ZERO_INT, Constants.ZERO_INT),
                "not less expected.");
        assertFalse(proxy.isLess(Constants.WIDE_PERCENTAGE_CAP_INT, Constants.PERCENTAGE_CAP_INT),
                "not less expected");
    }

    @Test
    public void isGreaterTest() {
        final ComparatorProxy.IntComparatorProxy proxy = initProxy();
        assertTrue(proxy.isGreater(Constants.WIDE_PERCENTAGE_CAP_INT, Constants.PERCENTAGE_CAP_INT),
                "greater expected.");
        assertFalse(proxy.isGreater(Constants.ZERO_INT, Constants.ZERO_INT),
                "not greater expected.");
        assertFalse(proxy.isGreater(Constants.PERCENTAGE_CAP_INT, Constants.WIDE_PERCENTAGE_CAP_INT),
                "not greater expected.");
    }

    @Test
    public void lessOrEqualTest() {
        final ComparatorProxy.IntComparatorProxy proxy = initProxy();
        assertTrue(proxy.lessOrEqual(Constants.ZERO_INT, Constants.ZERO_INT),
                "equality expected.");
        assertTrue(proxy.lessOrEqual(Constants.ZERO_INT, Constants.PERCENTAGE_CAP_INT),
                "less expected.");
        assertFalse(proxy.lessOrEqual(Constants.PERCENTAGE_CAP_INT, Constants.ZERO_INT),
                "not less or equal expected.");
    }

    @Test
    public void greaterOrEqualTest() {
        final ComparatorProxy.IntComparatorProxy proxy = initProxy();
        assertTrue(proxy.greaterOrEqual(Constants.ZERO_INT, Constants.ZERO_INT),
                "equality expected.");
        assertTrue(proxy.greaterOrEqual(Constants.PERCENTAGE_CAP_INT, Constants.ZERO_INT),
                "greater expected.");
        assertFalse(proxy.greaterOrEqual(Constants.ZERO_INT, Constants.PERCENTAGE_CAP_INT),
                "not greater or equal expected.");
    }

    private @NotNull ComparatorProxy.IntComparatorProxy initProxy() {
        return new IntegerComparatorProxyImpl();
    }
}
