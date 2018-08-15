import org.junit.Test;
import ru.rougegibbons.landsanddungeons.utils.functions.MathUtils;

import static org.junit.Assert.assertEquals;

public final class MathUtilsTest {
    @Test
    public void trimMinTestInt() {
        final Integer min = 0;
        final Integer biggerValue = 50;
        assertEquals("bigger value shall not be trimmed",
                biggerValue, MathUtils.trimMin(biggerValue, min));
        final Integer smallerValue = -1;
        assertEquals("smaller value shall be trimmed",
                min, MathUtils.trimMin(smallerValue, min));
        final Integer equalValue = 0;
        assertEquals("equal value shall be returned",
                equalValue, MathUtils.trimMin(equalValue, min));
    }

    @Test
    public void trimMaxTestInt() {
        final Integer max = 100;
        final Integer biggerValue = 500;
        assertEquals("bigger value shall be trimmed",
                max, MathUtils.trimMax(biggerValue, max));
        final Integer smallerValue = 50;
        assertEquals("smaller value shall not be trimmed",
                smallerValue, MathUtils.trimMax(smallerValue, max));
        final Integer equalValue = 100;
        assertEquals("equal value shall be returned",
                equalValue, MathUtils.trimMax(equalValue, max));
    }

    @Test
    public void clampTestInt() {
        final Integer min = 0;
        final Integer max = 100;
        final Integer betweenValue = 50;
        assertEquals("value between boundaries shall not be clamped",
                betweenValue, MathUtils.clamp(betweenValue, min, max));
        final Integer lowerValue = -1;
        assertEquals("lower values shall be clamped to minimum",
                min, MathUtils.clamp(lowerValue, min, max));
        final Integer biggerValue = 150;
        assertEquals("bigger values shall be clamped to maximum",
                max, MathUtils.clamp(biggerValue, min, max));
        final Integer minEqualValue = 0;
        assertEquals("values equal to boundaries shall not be clamped",
                minEqualValue, MathUtils.clamp(minEqualValue, min, max));
        final Integer maxEqualValue = 100;
        assertEquals("values equal to boundaries shall not be clamped",
                maxEqualValue, MathUtils.clamp(maxEqualValue, min, max));
    }

    @Test
    public void trimMinTestFloat() {
        final Float min = 0.0f;
        final Float biggerValue = 10.0f;
        assertEquals("bigger value shall not be trimmed",
                biggerValue, MathUtils.trimMin(biggerValue, min));
        final Float smallerValue = -1.0f;
        assertEquals("smaller value shall be trimmed",
                min, MathUtils.trimMin(smallerValue, min));
        final Float equalValue = 0.0000f;
        assertEquals("equal value shall be returned",
                equalValue, MathUtils.trimMin(equalValue, min));
        final Float equalValueTwo = 0.0000000001f;
        assertEquals("equal value shall be returned",
                equalValueTwo, MathUtils.trimMin(equalValueTwo, min));
    }

    @Test
    public void trimMaxTestFloat() {
        final Float max = 1.0f;
        final Float biggerValue = 5.0f;
        assertEquals("bigger value shall be trimmed",
                max, MathUtils.trimMax(biggerValue, max));
        final Float smallerValue = 0.5f;
        assertEquals("smaller value shall not be trimmed",
                smallerValue, MathUtils.trimMax(smallerValue, max));
        final Float equalValue = 1.00f;
        assertEquals("equal value shall be returned",
                equalValue, MathUtils.trimMax(equalValue, max));
        final Float equalValueTwo = 1.000000000001f;
        assertEquals("equal value shall be returned",
                equalValue, MathUtils.trimMax(equalValueTwo, max));
    }

    @Test
    public void clampTestFloat() {
        final Float min = 0.0f;
        final Float max = 1.0f;
        final Float betweenValue = 0.5f;
        assertEquals("value between boundaries shall not be clamped",
                betweenValue, MathUtils.clamp(betweenValue, min, max));
        final Float lowerValue = -1.5f;
        assertEquals("lower values shall be clamped to minimum",
                min, MathUtils.clamp(lowerValue, min, max));
        final Float biggerValue = 1.5f;
        assertEquals("bigger values shall be clamped to maximum",
                max, MathUtils.clamp(biggerValue, min, max));
        final Float minEqualValue = 0.0f;
        assertEquals("values equal to boundaries shall not be clamped",
                minEqualValue, MathUtils.clamp(minEqualValue, min, max));
        final Float maxEqualValue = 1.0f;
        assertEquals("values equal to boundaries shall not be clamped",
                maxEqualValue, MathUtils.clamp(maxEqualValue, min, max));
        final Float minDiffLowValue = min - 0.0000000000000001f;
        assertEquals("minimal float point difference shall not be clamped",
                minDiffLowValue, MathUtils.clamp(minDiffLowValue, min, max));
    }
}
