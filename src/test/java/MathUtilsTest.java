
import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.functions.MathUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class MathUtilsTest {
    @Test
    public void trimMinTestInt() {
        final Integer min = 0;
        final Integer biggerValue = 50;
        assertEquals(biggerValue, MathUtils.trimMin(biggerValue, min),
                "bigger value shall not be trimmed");
        final Integer smallerValue = -1;
        assertEquals(min, MathUtils.trimMin(smallerValue, min),
                "smaller value shall be trimmed");
        final Integer equalValue = 0;
        assertEquals(equalValue, MathUtils.trimMin(equalValue, min),
                "equal value shall be returned");
    }

    @Test
    public void trimMaxTestInt() {
        final Integer max = 100;
        final Integer biggerValue = 500;
        assertEquals(max, MathUtils.trimMax(biggerValue, max),
                "bigger value shall be trimmed");
        final Integer smallerValue = 50;
        assertEquals(smallerValue, MathUtils.trimMax(smallerValue, max),
                "smaller value shall not be trimmed");
        final Integer equalValue = 100;
        assertEquals(equalValue, MathUtils.trimMax(equalValue, max),
                "equal value shall be returned");
    }

    @Test
    public void clampTestInt() {
        final Integer min = 0;
        final Integer max = 100;
        final Integer betweenValue = 50;
        assertEquals(betweenValue, MathUtils.clamp(betweenValue, min, max),
                "value between boundaries shall not be clamped");
        final Integer lowerValue = -1;
        assertEquals(min, MathUtils.clamp(lowerValue, min, max),
                "lower values shall be clamped to minimum");
        final Integer biggerValue = 150;
        assertEquals(max, MathUtils.clamp(biggerValue, min, max),
                "bigger values shall be clamped to maximum");
        final Integer minEqualValue = 0;
        assertEquals(minEqualValue, MathUtils.clamp(minEqualValue, min, max),
                "values equal to boundaries shall not be clamped");
        final Integer maxEqualValue = 100;
        assertEquals(maxEqualValue, MathUtils.clamp(maxEqualValue, min, max),
                "values equal to boundaries shall not be clamped");
    }

    @Test
    public void trimMinTestFloat() {
        final Float min = 0.0f;
        final Float biggerValue = 10.0f;
        assertEquals(biggerValue, MathUtils.trimMin(biggerValue, min),
                "bigger value shall not be trimmed");
        final Float smallerValue = -1.0f;
        assertEquals(min, MathUtils.trimMin(smallerValue, min),
                "smaller value shall be trimmed");
        final Float equalValue = 0.0000f;
        assertEquals(equalValue, MathUtils.trimMin(equalValue, min),
                "equal value shall be returned");
        final Float equalValueTwo = 0.0000000001f;
        assertEquals(equalValueTwo, MathUtils.trimMin(equalValueTwo, min),
                "equal value shall be returned");
    }

    @Test
    public void trimMaxTestFloat() {
        final Float max = 1.0f;
        final Float biggerValue = 5.0f;
        assertEquals(max, MathUtils.trimMax(biggerValue, max),
                "bigger value shall be trimmed");
        final Float smallerValue = 0.5f;
        assertEquals(smallerValue, MathUtils.trimMax(smallerValue, max),
                "smaller value shall not be trimmed");
        final Float equalValue = 1.00f;
        assertEquals(equalValue, MathUtils.trimMax(equalValue, max),
                "equal value shall be returned");
        final Float equalValueTwo = 1.000000000001f;
        assertEquals(equalValue, MathUtils.trimMax(equalValueTwo, max),
                "equal value shall be returned");
    }

    @Test
    public void clampTestFloat() {
        final Float min = 0.0f;
        final Float max = 1.0f;
        final Float betweenValue = 0.5f;
        assertEquals(betweenValue, MathUtils.clamp(betweenValue, min, max),
                "value between boundaries shall not be clamped");
        final Float lowerValue = -1.5f;
        assertEquals(min, MathUtils.clamp(lowerValue, min, max),
                "lower values shall be clamped to minimum");
        final Float biggerValue = 1.5f;
        assertEquals(max, MathUtils.clamp(biggerValue, min, max),
                "bigger values shall be clamped to maximum");
        final Float minEqualValue = 0.0f;
        assertEquals(minEqualValue, MathUtils.clamp(minEqualValue, min, max),
                "values equal to boundaries shall not be clamped");
        final Float maxEqualValue = 1.0f;
        assertEquals(maxEqualValue, MathUtils.clamp(maxEqualValue, min, max),
                "values equal to boundaries shall not be clamped");
        final Float minDiffLowValue = min - 0.0000000000000001f;
        assertEquals(minDiffLowValue, MathUtils.clamp(minDiffLowValue, min, max),
                "minimal float point difference shall not be clamped");
    }
}
