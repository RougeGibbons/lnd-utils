package proxies;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.proxies.ComparatorProxy;
import ru.rougegibbons.landsanddungeons.utils.proxies.FloatComparatorProxyImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class FloatComparatorProxyImplTest {
    @Test
    public void areEqualTest() {
        final ComparatorProxy.FloatComparatorProxy proxy = initProxy();
        assertTrue(proxy.areEqual(Constants.ZERO_FLOAT, Constants.ZERO_FLOAT),
                "equality expected.");
        assertFalse(proxy.areEqual(Constants.ZERO_FLOAT, (float) Constants.PERCENTAGE_CAP_INT),
                "non-equality expected.");
    }

    @Test
    public void isLessTest() {
        final ComparatorProxy.FloatComparatorProxy proxy = initProxy();
        assertTrue(proxy.isLess((float) Constants.PERCENTAGE_CAP_INT, (float) Constants.WIDE_PERCENTAGE_CAP_INT),
                "less expected.");
        assertFalse(proxy.isLess(Constants.ZERO_FLOAT, Constants.ZERO_FLOAT),
                "not less expected.");
        assertFalse(proxy.isLess((float) Constants.WIDE_PERCENTAGE_CAP_INT, (float) Constants.PERCENTAGE_CAP_INT),
                "not less expected");
    }

    @Test
    public void isGreaterTest() {
        final ComparatorProxy.FloatComparatorProxy proxy = initProxy();
        assertTrue(proxy.isGreater((float) Constants.WIDE_PERCENTAGE_CAP_INT, (float) Constants.PERCENTAGE_CAP_INT),
                "greater expected.");
        assertFalse(proxy.isGreater(Constants.ZERO_FLOAT, Constants.ZERO_FLOAT),
                "not greater expected.");
        assertFalse(proxy.isGreater((float) Constants.PERCENTAGE_CAP_INT, (float) Constants.WIDE_PERCENTAGE_CAP_INT),
                "not greater expected.");
    }

    @Test
    public void lessOrEqualTest() {
        final ComparatorProxy.FloatComparatorProxy proxy = initProxy();
        assertTrue(proxy.lessOrEqual(Constants.ZERO_FLOAT, Constants.ZERO_FLOAT),
                "equality expected.");
        assertTrue(proxy.lessOrEqual(Constants.ZERO_FLOAT, (float) Constants.PERCENTAGE_CAP_INT),
                "less expected.");
        assertFalse(proxy.lessOrEqual((float) Constants.PERCENTAGE_CAP_INT, Constants.ZERO_FLOAT),
                "not less or equal expected.");
    }

    @Test
    public void greaterOrEqualTest() {
        final ComparatorProxy.FloatComparatorProxy proxy = initProxy();
        assertTrue(proxy.greaterOrEqual(Constants.ZERO_FLOAT, Constants.ZERO_FLOAT),
                "equality expected.");
        assertTrue(proxy.greaterOrEqual((float) Constants.PERCENTAGE_CAP_INT, Constants.ZERO_FLOAT),
                "greater expected.");
        assertFalse(proxy.greaterOrEqual(Constants.ZERO_FLOAT, (float) Constants.PERCENTAGE_CAP_INT),
                "not greater or equal expected.");
    }

    private @NotNull ComparatorProxy.FloatComparatorProxy initProxy() {
        return new FloatComparatorProxyImpl();
    }
}
