class Solution {
    public int rob(int[] nums) {
        // Edge case: If there are no houses, no money can be robbed.
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Edge case: If there is only one house, rob it.
        if (nums.length == 1) {
            return nums[0];
        }
        
        // Track the max money robbed up to two houses ago (dp[i-2])
        int prev2 = 0; 
        // Track the max money robbed up to the previous house (dp[i-1])
        int prev1 = 0; 
        
        // Iterate through each house
        for (int num : nums) {
            // Calculate the max if we rob the current house vs if we skip it
            int current = Math.max(prev1, prev2 + num);
            
            // Move our pointers forward for the next iteration
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}