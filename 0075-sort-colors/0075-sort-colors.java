class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Found a Red (0): move to the left section
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Found a White (1): keep in the middle
                mid++;
            } else {
                // Found a Blue (2): move to the right section
                swap(nums, mid, high);
                high--;
                // We don't increment mid here because the swapped element 
                // from 'high' could be a 0 and needs to be checked.
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}