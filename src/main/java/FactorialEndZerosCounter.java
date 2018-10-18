/**
 * Utility class that contains only 1 method, that allows to count
 * zeros at the end of the factorial value.
 */
class FactorialEndZerosCounter {

    /**
     * Returns the number of zeros in the end of the factorial value.
     * The main idea in Legendre's formula (https://en.wikipedia.org/wiki/Legendre%27s_formula) which
     * gives an expression for the exponent of the largest power of a prime "p" that divides the factorial n!.
     * In our case p = 5, because zero appears when 2 multiplies by 5. In decomposition on the prime numbers
     * twos is more than fives, so than we can have to find the power of 5 in decomposition - this is the number
     * of zeros in the end of the factorial value.
     *
     * @param number input number, which factorial value necessary to process
     * @return number of zeros in the end
     */
    static int calculateZeros(long number) {
        int zerosCount = 0;
        while (number > 0) {
            number /= 5;
            zerosCount += number;
        }
        return zerosCount;
    }
}
