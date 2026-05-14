class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
        // The maximum possible speed needed is the largest pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canFinish(piles, h, mid)) {
                // If she can finish at this speed, try a slower speed
                high = mid;
            } else {
                // If she can't finish, she must eat faster
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private boolean canFinish(int[] piles, int h, int k) {
        long totalHours = 0;
        for (int pile : piles) {
            // Calculate ceiling of (pile / k)
            totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }
}