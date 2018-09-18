package proxies;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.proxies.LongTrimmerProxyImpl;
import ru.rougegibbons.landsanddungeons.utils.proxies.TrimmerProxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class LongTrimmerProxyImplTest {
    @Test
    public void trimMinTest() {
        final TrimmerProxy.LongTrimmerProxy proxy = initProxy();
        final Long min = Constants.ZERO_LONG;
        final Long biggerValue = 50L;
        assertEquals(biggerValue, proxy.trimMin(biggerValue, min),
                "bigger value shall not be trimmed");
        final Long smallerValue = -1L;
        assertEquals(min, proxy.trimMin(smallerValue, min),
                "smaller value shall be trimmed");
        final Long equalValue = Constants.ZERO_LONG;
        assertEquals(equalValue, proxy.trimMin(equalValue, min),
                "equal value shall be returned");
    }

    @Test
    public void trimMaxTest() {
        final TrimmerProxy.LongTrimmerProxy proxy = initProxy();
        final Long max = (long) Constants.PERCENTAGE_CAP_INT;
        final Long biggerValue = 500L;
        assertEquals(max, proxy.trimMax(biggerValue, max),
                "bigger value shall be trimmed");
        final Long smallerValue = 50L;
        assertEquals(smallerValue, proxy.trimMax(smallerValue, max),
                "smaller value shall not be trimmed");
        final Long equalValue = (long) Constants.PERCENTAGE_CAP_INT;
        assertEquals(equalValue, proxy.trimMax(equalValue, max),
                "equal value shall be returned");
    }

    @Test
    public void clampTest() {
        final TrimmerProxy.LongTrimmerProxy proxy = initProxy();
        final Long min = Constants.ZERO_LONG;
        final Long max = (long) Constants.PERCENTAGE_CAP_INT;
        final Long betweenValue = 50L;
        assertEquals(betweenValue, proxy.clamp(betweenValue, min, max),
                "value between boundaries shall not be clamped");
        final Long lowerValue = -1L;
        assertEquals(min, proxy.clamp(lowerValue, min, max),
                "lower values shall be clamped to minimum");
        final Long biggerValue = 150L;
        assertEquals(max, proxy.clamp(biggerValue, min, max),
                "bigger values shall be clamped to maximum");
        final Long minEqualValue = Constants.ZERO_LONG;
        assertEquals(minEqualValue, proxy.clamp(minEqualValue, min, max),
                "values equal to boundaries shall not be clamped");
        final Long maxEqualValue = Constants.ZERO_LONG;
        assertEquals(maxEqualValue, proxy.clamp(maxEqualValue, min, max),
                "values equal to boundaries shall not be clamped");
    }

    private @NotNull TrimmerProxy.LongTrimmerProxy initProxy() {
        return new LongTrimmerProxyImpl();
    }
}
