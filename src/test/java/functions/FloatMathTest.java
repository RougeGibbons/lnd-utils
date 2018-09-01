package functions;

import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.functions.FloatMath;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public final class FloatMathTest {
    @Test
    public void addTest() {
        final Float lhsOne = 1.0f;
        final Float expected = 2.0f;
        assertEquals(expected, FloatMath.add(lhsOne, lhsOne),
                "doubled value expected");
        final Float smallAdd = 0.00001f;
        assertEquals(lhsOne, FloatMath.add(lhsOne, smallAdd),
                "small digit addition shall not change the value");
    }

    @Test
    public void subtractTest() {
        final Float lhsOne = 2.0f;
        final Float rhsOne = 1.0f;
        assertEquals(rhsOne, FloatMath.subtract(lhsOne, rhsOne),
                "halved value expected");
        final Float smallSubtract = 0.00001f;
        assertEquals(lhsOne, FloatMath.subtract(lhsOne, smallSubtract),
                "small digit subtraction shall not change the minuend");
    }

    @Test
    public void multiplyTest() {
        final Float lhsOne = 2.0f;
        final Float square = 4.0f;
        assertEquals(square, FloatMath.multiply(lhsOne, lhsOne),
                "squared value expected");
        final Float zero = 0.0f;
        final Float smallMultiplier = 0.00001f;
        assertEquals(zero, FloatMath.multiply(lhsOne, smallMultiplier),
                "small value multiplication shall be considered as zero multiplication");
    }

    @Test
    public void divideTest() {
        final Float lhsOne = 4.0f;
        final Float rhsOne = 2.0f;
        final Float expected = 2.0f;
        assertEquals(expected, FloatMath.divide(lhsOne, rhsOne),
                "halved value expected");
        final Float smallDivisor = 0.00001f;
        final Float zero = 0.0f;
        assertEquals(zero, FloatMath.divide(smallDivisor, rhsOne),
                "small dividend shall be considered as zero");
        try {
            FloatMath.divide(lhsOne, smallDivisor);
            fail("small divisor shall be considered as zero and throw exception");
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), containsString("/ by zero"));
            assertThat(e, instanceOf(ArithmeticException.class));
        }
    }
}
