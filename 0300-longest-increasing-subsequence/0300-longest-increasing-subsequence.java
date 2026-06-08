import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // tails array stores the smallest tail of all increasing subsequences
        int[] tails = new int[nums.length];
        int size = 0; // Tracks the current length of the longest subsequence
        
        for (int x : nums) {
            // Arrays.binarySearch searches the active range [0, size) for x
            int i = Arrays.binarySearch(tails, 0, size, x);
            
            // If x is not found, binarySearch returns: -(insertion_point) - 1
            // We can derive the correct insertion index with this bitwise complement:
            if (i < 0) {
                i = -(i + 1);
            }
            
            // Update the tail element at the determined index
            tails[i] = x;
            
            // If x was placed at the end of our active tails, the LIS size increases
            if (i == size) {
                size++;
            }
        }
        
        return size;
    }
}