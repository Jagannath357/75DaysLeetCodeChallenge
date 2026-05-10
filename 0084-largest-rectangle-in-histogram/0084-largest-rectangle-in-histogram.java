import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // Iterate through all bars, plus one extra 'zero' height at the end
        // to force the stack to clear out at the finish.
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            // While current bar is lower than the bar at stack top,
            // the stack top bar's rectangle is complete.
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                
                // If stack is empty, the width extends to the start of the histogram
                // Otherwise, the width is bounded by the new stack top index
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }

        return maxArea;
    }
}