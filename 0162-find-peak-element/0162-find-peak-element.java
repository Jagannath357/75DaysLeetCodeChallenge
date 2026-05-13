class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Standard binary search template
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare mid with the next element to see the slope
            if (nums[mid] < nums[mid + 1]) {
                // We are on an upward slope. 
                // The peak is to the right, and nums[mid] cannot be the peak.
                left = mid + 1;
            } else {
                // We are on a downward slope. 
                // nums[mid] could be the peak, or the peak is to the left.
                right = mid;
            }
        }

        // Left and Right converge to the peak index
        return left;
    }
}