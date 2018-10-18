import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialEndZerosCounterTest {

    private final long MAX_NUMBER_FOR_TESTING = 1000L;

    @Test
    public void testZeroZerosCounter() {
        for (long i = 0; i < MAX_NUMBER_FOR_TESTING; i++) {
            assertEquals(FactorialEndZerosCounter.calculateZeros(i), getZeroCount(i));
        }
    }

    private int getZeroCount(long number) {
        String numberInStringPresentation = factorial(number).toString();
        int counter = 0;
        for (int i = numberInStringPresentation.length() - 1; i >= 0; --i) {
            if (numberInStringPresentation.charAt(i) == '0') {
                ++counter;
                continue;
            }
            break;
        }
        return counter;
    }

    private BigInteger factorial(long number) {
        BigInteger result = BigInteger.ONE;
        BigInteger n = new BigInteger(String.valueOf(number));
        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }
        return result;
    }
}
