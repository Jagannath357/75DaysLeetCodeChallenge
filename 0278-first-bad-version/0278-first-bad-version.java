/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right) {
            // Using (left + right) / 2 can cause integer overflow 
            // if left and right are very large. This formula is safer:
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                // If mid is bad, the first bad version is mid or to the left
                right = mid;
            } else {
                // If mid is good, the first bad version is strictly to the right
                left = mid + 1;
            }
        }
        
        // When left == right, we've converged on the first bad version
        return left;
    }
}