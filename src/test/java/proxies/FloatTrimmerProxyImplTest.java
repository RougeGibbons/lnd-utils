package proxies;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.proxies.FloatTrimmerProxyImpl;
import ru.rougegibbons.landsanddungeons.utils.proxies.TrimmerProxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class FloatTrimmerProxyImplTest {
    @Test
    public void trimMinTest() {
        final TrimmerProxy.FloatTrimmerProxy proxy = initProxy();
        final Float min = Constants.ZERO_FLOAT;
        final Float biggerValue = 50.0f;
        assertEquals(biggerValue, proxy.trimMin(biggerValue, min),
                "bigger value shall not be trimmed");
        final Float smallerValue = -1.0f;
        assertEquals(min, proxy.trimMin(smallerValue, min),
                "smaller value shall be trimmed");
        final Float equalValue = Constants.ZERO_FLOAT;
        assertEquals(equalValue, proxy.trimMin(equalValue, min),
                "equal value shall be returned");
    }

    @Test
    public void trimMaxTest() {
        final TrimmerProxy.FloatTrimmerProxy proxy = initProxy();
        final Float max = (float) Constants.PERCENTAGE_CAP_INT;
        final Float biggerValue = (float) 500;
        assertEquals(max, proxy.trimMax(biggerValue, max),
                "bigger value shall be trimmed");
        final Float smallerValue = (float) 50;
        assertEquals(smallerValue, proxy.trimMax(smallerValue, max),
                "smaller value shall not be trimmed");
        final Float equalValue = (float) Constants.PERCENTAGE_CAP_INT;
        assertEquals(equalValue, proxy.trimMax(equalValue, max),
                "equal value shall be returned");
    }

    @Test
    public void clampTest() {
        final TrimmerProxy.FloatTrimmerProxy proxy = initProxy();
        final Float min = Constants.ZERO_FLOAT;
        final Float max = (float) Constants.PERCENTAGE_CAP_INT;
        final Float betweenValue = (float) 50;
        assertEquals(betweenValue, proxy.clamp(betweenValue, min, max),
                "value between boundaries shall not be clamped");
        final Float lowerValue = -1.0f;
        assertEquals(min, proxy.clamp(lowerValue, min, max),
                "lower values shall be clamped to minimum");
        final Float biggerValue = (float) 150;
        assertEquals(max, proxy.clamp(biggerValue, min, max),
                "bigger values shall be clamped to maximum");
        final Float minEqualValue = Constants.ZERO_FLOAT;
        assertEquals(minEqualValue, proxy.clamp(minEqualValue, min, max),
                "values equal to boundaries shall not be clamped");
        final Float maxEqualValue = Constants.ZERO_FLOAT;
        assertEquals(maxEqualValue, proxy.clamp(maxEqualValue, min, max),
                "values equal to boundaries shall not be clamped");
    }

    private @NotNull TrimmerProxy.FloatTrimmerProxy initProxy() {
        return new FloatTrimmerProxyImpl();
    }
}
