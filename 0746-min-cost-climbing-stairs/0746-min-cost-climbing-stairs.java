class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        // Base cases: the cost to start at step 0 or step 1 is 0.
        int prev2 = 0; 
        int prev1 = 0; 
        
        // Compute optimal cost for each step iteratively
        for (int i = 2; i <= n; i++) {
            int current = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            
            // Move variables forward to slide the window
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}