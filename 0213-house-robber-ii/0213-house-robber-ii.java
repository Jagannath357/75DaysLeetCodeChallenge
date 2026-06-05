class Solution {
    public int rob(int[] nums) {
        // Edge cases
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // Scenario 1: Rob from house 0 to n-2
        int max1 = robLinear(nums, 0, nums.length - 2);
        // Scenario 2: Rob from house 1 to n-1
        int max2 = robLinear(nums, 1, nums.length - 1);

        // The answer is the maximum yield of the two scenarios
        return Math.max(max1, max2);
    }

    // Helper method to solve the standard linear House Robber problem
    private int robLinear(int[] nums, int start, int end) {
        int prevMax = 0; // Represents DP[i-2]
        int currMax = 0; // Represents DP[i-1]

        for (int i = start; i <= end; i++) {
            int temp = currMax;
            // Decide whether to rob the current house or skip it
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }

        return currMax;
    }
}