import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequencies of each task
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        // Step 2: Sort to easily find the max frequency
        Arrays.sort(frequencies);
        int maxFreq = frequencies[25];

        // Step 3: Calculate the maximum possible idle slots needed
        int chunkCount = maxFreq - 1;
        int idleSlots = chunkCount * n;

        // Step 4: Reduce idle slots by filling them with other tasks
        for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            // A task cannot fill more slots than the chunk count
            idleSlots -= Math.min(chunkCount, frequencies[i]);
        }

        // Step 5: If idle slots become negative, it means no idle time is required
        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }
}