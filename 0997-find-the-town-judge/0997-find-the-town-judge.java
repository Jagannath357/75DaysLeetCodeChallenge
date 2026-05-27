class Solution {
    public int findJudge(int n, int[][] trust) {
        // Array to track net trust score for each person (1-indexed)
        int[] trustScores = new int[n + 1];
        
        // Process each trust relationship
        for (int[] relation : trust) {
            int citizen = relation[0];
            int candidate = relation[1];
            
            // Person 'citizen' trusts someone, so they lose score
            trustScores[citizen]--;
            
            // Person 'candidate' is trusted, so they gain score
            trustScores[candidate]++;
        }
        
        // Check if any person meets the judge criteria (score == n - 1)
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}