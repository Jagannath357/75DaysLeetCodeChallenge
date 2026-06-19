class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;
        
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // If current height is greater than or equal to leftMax, update leftMax
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Trapped water is the difference between leftMax and current height
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                // If current height is greater than or equal to rightMax, update rightMax
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Trapped water is the difference between rightMax and current height
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }
}