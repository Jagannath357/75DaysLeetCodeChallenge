class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        // If s1 is longer than s2, s2 cannot contain a permutation of s1
        if (n1 > n2) return false;

        // Frequency maps for s1 and the current window in s2
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Fill the initial counts for s1 and the first window of s2
        for (int i = 0; i < n1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Slide the window across s2
        // We iterate up to n2 - n1 to check every possible window
        for (int i = 0; i < n2 - n1; i++) {
            if (matches(s1Count, s2Count)) return true;
            
            // Update the window: move right
            // Add the next character (i + n1) and remove the first character (i)
            s2Count[s2.charAt(i + n1) - 'a']++;
            s2Count[s2.charAt(i) - 'a']--;
        }

        // Check the last window
        return matches(s1Count, s2Count);
    }

    // Helper method to compare two frequency arrays
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }
}