package proxies;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.proxies.IntegerTrimmerProxyImpl;
import ru.rougegibbons.landsanddungeons.utils.proxies.TrimmerProxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class IntegerTrimmerProxyImplTest {
    @Test
    public void trimMinTest() {
        final TrimmerProxy.IntTrimmerProxy proxy = initProxy();
        final Integer min = Constants.ZERO_INT;
        final Integer biggerValue = 50;
        assertEquals(biggerValue, proxy.trimMin(biggerValue, min),
                "bigger value shall not be trimmed");
        final Integer smallerValue = -1;
        assertEquals(min, proxy.trimMin(smallerValue, min),
                "smaller value shall be trimmed");
        final Integer equalValue = Constants.ZERO_INT;
        assertEquals(equalValue, proxy.trimMin(equalValue, min),
                "equal value shall be returned");
    }

    @Test
    public void trimMaxTest() {
        final TrimmerProxy.IntTrimmerProxy proxy = initProxy();
        final Integer max = Constants.PERCENTAGE_CAP_INT;
        final Integer biggerValue = 500;
        assertEquals(max, proxy.trimMax(biggerValue, max),
                "bigger value shall be trimmed");
        final Integer smallerValue = 50;
        assertEquals(smallerValue, proxy.trimMax(smallerValue, max),
                "smaller value shall not be trimmed");
        final Integer equalValue = Constants.PERCENTAGE_CAP_INT;
        assertEquals(equalValue, proxy.trimMax(equalValue, max),
                "equal value shall be returned");
    }

    @Test
    public void clampTest() {
        final TrimmerProxy.IntTrimmerProxy proxy = initProxy();
        final Integer min = Constants.ZERO_INT;
        final Integer max = Constants.PERCENTAGE_CAP_INT;
        final Integer betweenValue = 50;
        assertEquals(betweenValue, proxy.clamp(betweenValue, min, max),
                "value between boundaries shall not be clamped");
        final Integer lowerValue = -1;
        assertEquals(min, proxy.clamp(lowerValue, min, max),
                "lower values shall be clamped to minimum");
        final Integer biggerValue = 150;
        assertEquals(max, proxy.clamp(biggerValue, min, max),
                "bigger values shall be clamped to maximum");
        final Integer minEqualValue = Constants.ZERO_INT;
        assertEquals(minEqualValue, proxy.clamp(minEqualValue, min, max),
                "values equal to boundaries shall not be clamped");
        final Integer maxEqualValue = Constants.ZERO_INT;
        assertEquals(maxEqualValue, proxy.clamp(maxEqualValue, min, max),
                "values equal to boundaries shall not be clamped");
    }

    private @NotNull TrimmerProxy.IntTrimmerProxy initProxy() {
        return new IntegerTrimmerProxyImpl();
    }
}
