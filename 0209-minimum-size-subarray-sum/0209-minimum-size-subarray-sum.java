class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Initialize variables
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;

        // Iterate through the array with the 'right' pointer
        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            // While the sum of the current window is >= target, shrink from the left
            while (currentSum >= target) {
                // Update the minimum length found so far
                minLength = Math.min(minLength, right - left + 1);
                
                // Subtract the leftmost element and move the left pointer forward
                currentSum -= nums[left];
                left++;
            }
        }

        // If minLength was never updated, it means no such subarray exists
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}