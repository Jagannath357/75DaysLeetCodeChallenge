class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: overflow handling
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        // True if the result should be negative
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative to prevent overflow
        // (Integer.MIN_VALUE cannot be converted to positive safely in a 32-bit int)
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Exponential search / Bit manipulation
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;

            // Double the divisor until it's larger than the remaining dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest found multiple from dividend
            absDividend -= tempDivisor;
            // Add the multiple to the quotient
            quotient += multiple;
        }

        // Apply the sign to the result
        return isNegative ? -quotient : quotient;
    }
}