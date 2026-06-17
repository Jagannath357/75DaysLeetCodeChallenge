import java.util.Arrays;

public class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        
        // If there's only 1 point, no lines can be drawn.
        // If there are 2 points, exactly 1 line connects them.
        if (n <= 1) return 0;
        if (n == 2) return 1;

        // Step 1: Sort stock prices by day (X-axis)
        Arrays.sort(stockPrices, (a, b) -> Integer.compare(a[0], b[0]));

        // We always need at least 1 line to connect the first two points
        int lineCount = 1;

        // Step 2: Iterate through the remaining points and check slope changes
        for (int i = 2; i < n; i++) {
            long x1 = stockPrices[i - 2][0];
            long y1 = stockPrices[i - 2][1];
            
            long x2 = stockPrices[i - 1][0];
            long y2 = stockPrices[i - 1][1];
            
            long x3 = stockPrices[i][0];
            long y3 = stockPrices[i][1];

            // Cross-multiplication to check slope equality: (y2 - y1)/(x2 - x1) == (y3 - y2)/(x3 - x2)
            long diffY1 = y2 - y1;
            long diffX1 = x2 - x1;
            long diffY2 = y3 - y2;
            long diffX2 = x3 - x2;

            // If the slopes are not equal, a new line segment starts
            if (diffY1 * diffX2 != diffY2 * diffX1) {
                lineCount++;
            }
        }

        return lineCount;
    }
}