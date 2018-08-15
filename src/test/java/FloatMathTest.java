import org.junit.Test;
import ru.rougegibbons.landsanddungeons.utils.functions.FloatMath;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public final class FloatMathTest {
    @Test
    public void addTest() {
        final Float lhsOne = 1.0f;
        final Float expected = 2.0f;
        assertEquals("doubled value expected",
                expected, FloatMath.add(lhsOne, lhsOne));
        final Float smallAdd = 0.00001f;
        assertEquals("small digit addition shall not change the value",
                lhsOne, FloatMath.add(lhsOne, smallAdd));
    }

    @Test
    public void subtractTest() {
        final Float lhsOne = 2.0f;
        final Float rhsOne = 1.0f;
        assertEquals("halved value expected",
                rhsOne, FloatMath.subtract(lhsOne, rhsOne));
        final Float smallSubtract = 0.00001f;
        assertEquals("small digit subtraction shall not change the minuend",
                lhsOne, FloatMath.subtract(lhsOne, smallSubtract));
    }

    @Test
    public void multiplyTest() {
        final Float lhsOne = 2.0f;
        final Float square = 4.0f;
        assertEquals("squared value expected",
                square, FloatMath.multiply(lhsOne, lhsOne));
        final Float zero = 0.0f;
        final Float smallMultiplier = 0.00001f;
        assertEquals("small value multiplication shall be considered as zero multiplication",
                zero, FloatMath.multiply(lhsOne, smallMultiplier));
    }

    @Test
    public void divideTest() {
        final Float lhsOne = 4.0f;
        final Float rhsOne = 2.0f;
        final Float expected = 2.0f;
        assertEquals("halved value expected",
                expected, FloatMath.divide(lhsOne, rhsOne));
        final Float smallDivisor = 0.00001f;
        final Float zero = 0.0f;
        assertEquals("small dividend shall be considered as zero",
                zero, FloatMath.divide(smallDivisor, rhsOne));
        try {
            FloatMath.divide(lhsOne, smallDivisor);
            fail("small divisor shall be considered as zero and throw exception");
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), containsString("/ by zero"));
            assertThat(e, instanceOf(ArithmeticException.class));
        }
    }
}
