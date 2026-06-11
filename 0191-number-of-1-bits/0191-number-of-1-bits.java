class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            // This bitwise trick clears the lowest set bit (1) of n
            n = n & (n - 1); 
            count++;
        }
        
        return count;
    }
}