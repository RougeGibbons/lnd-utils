package proxies;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.proxies.ArithmeticsProxy;
import ru.rougegibbons.landsanddungeons.utils.proxies.LongArithmeticsProxyImpl;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public final class LongArithmeticsProxyImplTest {
    @Test
    public void addTest() {
        final ArithmeticsProxy.LongArithmeticsProxy proxy = initProxy();
        addCheck(Constants.ZERO_LONG, proxy.add(Constants.ZERO_LONG, Constants.ZERO_LONG));
        addCheck((long) Constants.PERCENTAGE_CAP_INT, proxy.add(
                (long) Constants.PERCENTAGE_CAP_INT, (long) Constants.ZERO_INT));
        addCheck((long) Constants.PERCENTAGE_CAP_INT + (long) Constants.WIDE_PERCENTAGE_CAP_INT,
                proxy.add((long) Constants.WIDE_PERCENTAGE_CAP_INT, (long) Constants.PERCENTAGE_CAP_INT));
    }

    @Test
    public void subtractTest() {
        final ArithmeticsProxy.LongArithmeticsProxy proxy = initProxy();
        subtractCheck(Constants.ZERO_LONG, proxy.subtract(Constants.ZERO_LONG, Constants.ZERO_LONG));
        subtractCheck((long) Constants.PERCENTAGE_CAP_INT, proxy.subtract(
                (long) Constants.PERCENTAGE_CAP_INT, Constants.ZERO_LONG));
        subtractCheck((long) Constants.WIDE_PERCENTAGE_CAP_INT - (long) Constants.PERCENTAGE_CAP_INT,
                proxy.subtract((long) Constants.WIDE_PERCENTAGE_CAP_INT, (long) Constants.PERCENTAGE_CAP_INT));
        subtractCheck(Constants.ZERO_LONG, proxy.subtract(
                (long) Constants.PERCENTAGE_CAP_INT, (long) Constants.PERCENTAGE_CAP_INT));
    }

    @Test
    public void multiplyTest() {
        final ArithmeticsProxy.LongArithmeticsProxy proxy = initProxy();
        multiplyCheck(Constants.ZERO_LONG, proxy.multiply(Constants.ZERO_LONG, Constants.ZERO_LONG));
        multiplyCheck(Constants.ZERO_LONG, proxy.multiply((long) Constants.PERCENTAGE_CAP_INT, Constants.ZERO_LONG));
        multiplyCheck((long) Constants.PERCENTAGE_CAP_INT * (long) Constants.WIDE_PERCENTAGE_CAP_INT,
                proxy.multiply((long) Constants.WIDE_PERCENTAGE_CAP_INT, (long) Constants.PERCENTAGE_CAP_INT));
        multiplyCheck((long) Constants.PERCENTAGE_CAP_INT * (long) Constants.PERCENTAGE_CAP_INT,
                proxy.multiply((long) Constants.PERCENTAGE_CAP_INT, (long) Constants.PERCENTAGE_CAP_INT));
    }

    @Test
    public void divideTest() {
        final ArithmeticsProxy.LongArithmeticsProxy proxy = initProxy();
        try {
            divideCheck(Constants.ZERO_LONG, proxy.divide(Constants.ZERO_LONG, Constants.ZERO_LONG));
            fail("zero division is not allowed.");
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), containsString("/ by zero"));
            assertThat(e, instanceOf(ArithmeticException.class));
        }
        divideCheck(Constants.ZERO_LONG, proxy.divide(
                Constants.ZERO_LONG, (long) Constants.WIDE_PERCENTAGE_CAP_INT));
        divideCheck((long) Constants.WIDE_PERCENTAGE_CAP_INT / (long) Constants.PERCENTAGE_CAP_INT,
                proxy.divide((long) Constants.WIDE_PERCENTAGE_CAP_INT, (long) Constants.PERCENTAGE_CAP_INT));
    }

    @Test
    public void percentageModificationTest() {
        final ArithmeticsProxy.LongArithmeticsProxy proxy = initProxy();
        percentageModificationCheck(Constants.ZERO_LONG, proxy.modifyByPercentage(
                Constants.ZERO_LONG, Constants.ZERO_INT));
        percentageModificationCheck(Constants.ZERO_LONG, proxy.modifyByPercentage(
                Constants.ZERO_LONG, Constants.ZERO_FLOAT));
        percentageModificationCheck(Constants.ZERO_LONG, proxy.modifyByPercentage(
                Constants.ZERO_LONG, Constants.PERCENTAGE_CAP_INT));
        percentageModificationCheck(Constants.ZERO_LONG, proxy.modifyByPercentage(
                Constants.ZERO_LONG, Constants.PERCENTAGE_CAP_FLOAT));
        percentageModificationCheck((long) Constants.PERCENTAGE_CAP_INT, proxy.modifyByPercentage(
                (long) Constants.PERCENTAGE_CAP_INT, Constants.ZERO_FLOAT));
        percentageModificationCheck((long) Constants.PERCENTAGE_CAP_INT, proxy.modifyByPercentage(
                (long) Constants.PERCENTAGE_CAP_INT, Constants.ZERO_INT));
        percentageModificationCheck((long) (Constants.WIDE_PERCENTAGE_CAP_INT
                + Constants.PERCENTAGE_CAP_INT), proxy.modifyByPercentage(
                (long) Constants.PERCENTAGE_CAP_INT, (float) Constants.PERCENTAGE_CAP_INT));
        percentageModificationCheck((long) (Constants.WIDE_PERCENTAGE_CAP_INT
                + Constants.PERCENTAGE_CAP_INT), proxy.modifyByPercentage(
                (long) Constants.PERCENTAGE_CAP_INT, Constants.WIDE_PERCENTAGE_CAP_INT));
    }

    private @NotNull ArithmeticsProxy.LongArithmeticsProxy initProxy() {
        return new LongArithmeticsProxyImpl();
    }

    private void operationCheck(@NotNull String operationName,
                                @NotNull Long expected,
                                @NotNull Long result) {
        assertEquals(expected, result, operationName + " operation error: "
                + expected + " expected instead of " + result);
    }

    private void addCheck(@NotNull Long expected,
                          @NotNull Long result) {
        operationCheck("addition", expected, result);
    }

    private void subtractCheck(@NotNull Long expected,
                               @NotNull Long result) {
        operationCheck("subtraction", expected, result);
    }

    private void multiplyCheck(@NotNull Long expected,
                               @NotNull Long result) {
        operationCheck("multiplication", expected, result);
    }

    private void divideCheck(@NotNull Long expected,
                             @NotNull Long result) {
        operationCheck("division ", expected, result);
    }

    private void percentageModificationCheck(@NotNull Long expected,
                                             @NotNull Long result) {
        operationCheck("percentage modification ", expected, result);
    }
}
