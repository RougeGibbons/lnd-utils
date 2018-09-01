package proxies;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.functions.FloatComparator;
import ru.rougegibbons.landsanddungeons.utils.proxies.ArithmeticsProxy;
import ru.rougegibbons.landsanddungeons.utils.proxies.FloatArithmeticsProxyImpl;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public final class FloatArithmeticsProxyImplTest {
    @Test
    public void addTest() {
        final ArithmeticsProxy.FloatArithmeticsProxy proxy = initProxy();
        addCheck(Constants.ZERO_FLOAT, proxy.add(Constants.ZERO_FLOAT, Constants.ZERO_FLOAT));
        addCheck((float) Constants.PERCENTAGE_CAP_INT, proxy.add(
                (float) Constants.PERCENTAGE_CAP_INT, Constants.ZERO_FLOAT));
        addCheck((float) Constants.PERCENTAGE_CAP_INT + (float) Constants.WIDE_PERCENTAGE_CAP_INT,
                proxy.add((float) Constants.WIDE_PERCENTAGE_CAP_INT, (float) Constants.PERCENTAGE_CAP_INT));
    }

    @Test
    public void subtractTest() {
        final ArithmeticsProxy.FloatArithmeticsProxy proxy = initProxy();
        subtractCheck(Constants.ZERO_FLOAT, proxy.subtract(Constants.ZERO_FLOAT, Constants.ZERO_FLOAT));
        subtractCheck((float) Constants.PERCENTAGE_CAP_INT, proxy.subtract(
                (float) Constants.PERCENTAGE_CAP_INT, Constants.ZERO_FLOAT));
        subtractCheck((float) Constants.WIDE_PERCENTAGE_CAP_INT - (float) Constants.PERCENTAGE_CAP_INT,
                proxy.subtract((float) Constants.WIDE_PERCENTAGE_CAP_INT,
                        (float) Constants.PERCENTAGE_CAP_INT));
        subtractCheck(Constants.ZERO_FLOAT, proxy.subtract(
                (float) Constants.PERCENTAGE_CAP_INT,
                (float) Constants.PERCENTAGE_CAP_INT));
    }

    @Test
    public void multiplyTest() {
        final ArithmeticsProxy.FloatArithmeticsProxy proxy = initProxy();
        multiplyCheck(Constants.ZERO_FLOAT, proxy.multiply(Constants.ZERO_FLOAT, Constants.ZERO_FLOAT));
        multiplyCheck(Constants.ZERO_FLOAT, proxy.multiply(
                (float) Constants.PERCENTAGE_CAP_INT, Constants.ZERO_FLOAT));
        multiplyCheck((float) Constants.PERCENTAGE_CAP_INT * (float) Constants.WIDE_PERCENTAGE_CAP_INT,
                proxy.multiply((float) Constants.WIDE_PERCENTAGE_CAP_INT,
                        (float) Constants.PERCENTAGE_CAP_INT));
        multiplyCheck((float) Constants.PERCENTAGE_CAP_INT * (float) Constants.PERCENTAGE_CAP_INT,
                proxy.multiply((float) Constants.PERCENTAGE_CAP_INT,
                        (float) Constants.PERCENTAGE_CAP_INT));
    }

    @Test
    public void divideTest() {
        final ArithmeticsProxy.FloatArithmeticsProxy proxy = initProxy();
        try {
            divideCheck(Constants.ZERO_FLOAT, proxy.divide(Constants.ZERO_FLOAT, Constants.ZERO_FLOAT));
            fail("zero division is not allowed.");
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), containsString("/ by zero"));
            assertThat(e, instanceOf(ArithmeticException.class));
        }
        divideCheck(Constants.ZERO_FLOAT, proxy.divide(
                Constants.ZERO_FLOAT, (float) Constants.WIDE_PERCENTAGE_CAP_INT));
        divideCheck((float) Constants.WIDE_PERCENTAGE_CAP_INT / (float) Constants.PERCENTAGE_CAP_INT,
                proxy.divide((float) Constants.WIDE_PERCENTAGE_CAP_INT, (float) Constants.PERCENTAGE_CAP_INT));
    }

    private @NotNull ArithmeticsProxy.FloatArithmeticsProxy initProxy() {
        return new FloatArithmeticsProxyImpl();
    }

    private void operationCheck(@NotNull String operationName,
                                @NotNull Float expected,
                                @NotNull Float result) {
        assertTrue(FloatComparator.areEqual(expected, result),
                operationName + " operation error: "
                        + expected + " expected instead of " + result);
    }

    private void addCheck(@NotNull Float expected,
                          @NotNull Float result) {
        operationCheck("addition", expected, result);
    }

    private void subtractCheck(@NotNull Float expected,
                               @NotNull Float result) {
        operationCheck("subtraction", expected, result);
    }

    private void multiplyCheck(@NotNull Float expected,
                               @NotNull Float result) {
        operationCheck("multiplication", expected, result);
    }

    private void divideCheck(@NotNull Float expected,
                             @NotNull Float result) {
        operationCheck("division ", expected, result);
    }
}
