import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k; // Target index in ascending order
        
        // Shuffle to prevent worst-case scenarios on pre-sorted arrays
        shuffle(nums);
        
        int left = 0;
        int right = n - 1;
        
        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        
        return -1;
    }
    
    // Hoare's 2-Pointer Partitioning (Highly robust against duplicate values)
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        
        while (true) {
            // Move the left pointer forward as long as elements are smaller than the pivot
            while (i <= right && nums[i] < pivot) {
                i++;
            }
            // Move the right pointer backward as long as elements are larger than the pivot
            while (j >= left && nums[j] > pivot) {
                j--;
            }
            
            if (i >= j) break;
            
            swap(nums, i, j);
            i++;
            j--;
        }
        
        // Place the pivot in its correct sorted position
        swap(nums, left, j);
        return j;
    }
    
    private void shuffle(int[] nums) {
        Random rand = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            swap(nums, i, index);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}