package proxies;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.proxies.ArithmeticsProxy;
import ru.rougegibbons.landsanddungeons.utils.proxies.IntegerArithmeticsProxyImpl;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public final class IntegerArithmeticsProxyImplTest {
    @Test
    public void addTest() {
        final ArithmeticsProxy.IntArithmeticsProxy proxy = initProxy();
        addCheck(Constants.ZERO_INT, proxy.add(Constants.ZERO_INT, Constants.ZERO_INT));
        addCheck(Constants.PERCENTAGE_CAP_INT, proxy.add(Constants.PERCENTAGE_CAP_INT, Constants.ZERO_INT));
        addCheck(Constants.PERCENTAGE_CAP_INT + Constants.WIDE_PERCENTAGE_CAP_INT,
                proxy.add(Constants.WIDE_PERCENTAGE_CAP_INT, Constants.PERCENTAGE_CAP_INT));
    }

    @Test
    public void subtractTest() {
        final ArithmeticsProxy.IntArithmeticsProxy proxy = initProxy();
        subtractCheck(Constants.ZERO_INT, proxy.subtract(Constants.ZERO_INT, Constants.ZERO_INT));
        subtractCheck(Constants.PERCENTAGE_CAP_INT, proxy.subtract(
                Constants.PERCENTAGE_CAP_INT, Constants.ZERO_INT));
        subtractCheck(Constants.WIDE_PERCENTAGE_CAP_INT - Constants.PERCENTAGE_CAP_INT,
                proxy.subtract(Constants.WIDE_PERCENTAGE_CAP_INT, Constants.PERCENTAGE_CAP_INT));
        subtractCheck(Constants.ZERO_INT, proxy.subtract(
                Constants.PERCENTAGE_CAP_INT, Constants.PERCENTAGE_CAP_INT));
    }

    @Test
    public void multiplyTest() {
        final ArithmeticsProxy.IntArithmeticsProxy proxy = initProxy();
        multiplyCheck(Constants.ZERO_INT, proxy.multiply(Constants.ZERO_INT, Constants.ZERO_INT));
        multiplyCheck(Constants.ZERO_INT, proxy.multiply(Constants.PERCENTAGE_CAP_INT, Constants.ZERO_INT));
        multiplyCheck(Constants.PERCENTAGE_CAP_INT * Constants.WIDE_PERCENTAGE_CAP_INT,
                proxy.multiply(Constants.WIDE_PERCENTAGE_CAP_INT, Constants.PERCENTAGE_CAP_INT));
        multiplyCheck(Constants.PERCENTAGE_CAP_INT * Constants.PERCENTAGE_CAP_INT,
                proxy.multiply(Constants.PERCENTAGE_CAP_INT, Constants.PERCENTAGE_CAP_INT));
    }

    @Test
    public void divideTest() {
        final ArithmeticsProxy.IntArithmeticsProxy proxy = initProxy();
        try {
            divideCheck(Constants.ZERO_INT, proxy.divide(Constants.ZERO_INT, Constants.ZERO_INT));
            fail("zero division is not allowed.");
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), containsString("/ by zero"));
            assertThat(e, instanceOf(ArithmeticException.class));
        }
        divideCheck(Constants.ZERO_INT, proxy.divide(
                Constants.ZERO_INT, Constants.WIDE_PERCENTAGE_CAP_INT));
        divideCheck(Constants.WIDE_PERCENTAGE_CAP_INT / Constants.PERCENTAGE_CAP_INT,
                proxy.divide(Constants.WIDE_PERCENTAGE_CAP_INT, Constants.PERCENTAGE_CAP_INT));
    }

    @Test
    public void percentageModificationTest() {
        final ArithmeticsProxy.IntArithmeticsProxy proxy = initProxy();
        percentageModificationCheck(Constants.ZERO_INT, proxy.modifyByPercentage(
                Constants.ZERO_INT, Constants.ZERO_INT));
        percentageModificationCheck(Constants.ZERO_INT, proxy.modifyByPercentage(
                Constants.ZERO_INT, Constants.ZERO_FLOAT));
        percentageModificationCheck(Constants.ZERO_INT, proxy.modifyByPercentage(
                Constants.ZERO_INT, Constants.PERCENTAGE_CAP_INT));
        percentageModificationCheck(Constants.ZERO_INT, proxy.modifyByPercentage(
                Constants.ZERO_INT, Constants.PERCENTAGE_CAP_FLOAT));
        percentageModificationCheck(Constants.PERCENTAGE_CAP_INT, proxy.modifyByPercentage(
                Constants.PERCENTAGE_CAP_INT, Constants.ZERO_FLOAT));
        percentageModificationCheck(Constants.PERCENTAGE_CAP_INT, proxy.modifyByPercentage(
                Constants.PERCENTAGE_CAP_INT, Constants.ZERO_INT));
        percentageModificationCheck(Constants.WIDE_PERCENTAGE_CAP_INT
                + Constants.PERCENTAGE_CAP_INT, proxy.modifyByPercentage(
                Constants.PERCENTAGE_CAP_INT, (float) Constants.PERCENTAGE_CAP_INT));
        percentageModificationCheck(Constants.WIDE_PERCENTAGE_CAP_INT
                + Constants.PERCENTAGE_CAP_INT, proxy.modifyByPercentage(
                Constants.PERCENTAGE_CAP_INT, Constants.WIDE_PERCENTAGE_CAP_INT));
    }

    private @NotNull ArithmeticsProxy.IntArithmeticsProxy initProxy() {
        return new IntegerArithmeticsProxyImpl();
    }

    private void operationCheck(@NotNull String operationName,
                                @NotNull Integer expected,
                                @NotNull Integer result) {
        assertEquals(expected, result, operationName + " operation error: "
                + expected + " expected instead of " + result);
    }

    private void addCheck(@NotNull Integer expected,
                          @NotNull Integer result) {
        operationCheck("addition", expected, result);
    }

    private void subtractCheck(@NotNull Integer expected,
                               @NotNull Integer result) {
        operationCheck("subtraction", expected, result);
    }

    private void multiplyCheck(@NotNull Integer expected,
                               @NotNull Integer result) {
        operationCheck("multiplication", expected, result);
    }

    private void divideCheck(@NotNull Integer expected,
                             @NotNull Integer result) {
        operationCheck("division ", expected, result);
    }

    private void percentageModificationCheck(@NotNull Integer expected,
                                             @NotNull Integer result) {
        operationCheck("percentage modification ", expected, result);
    }
}
