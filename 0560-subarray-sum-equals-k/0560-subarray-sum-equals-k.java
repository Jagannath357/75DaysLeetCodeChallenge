import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        
        // Map to store (prefixSum, frequency)
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base case: a prefix sum of 0 has been seen once (important for subarrays starting at index 0)
        map.put(0, 1);
        
        for (int num : nums) {
            prefixSum += num;
            
            // If (prefixSum - k) exists in the map, it means there is a subarray 
            // ending here that sums to k.
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            
            // Update the frequency of the current prefixSum in the map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}