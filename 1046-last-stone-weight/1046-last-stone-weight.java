import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Create a Max-Heap by passing a reverse order comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all stones to the heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        // Process until 0 or 1 stone remains
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // Heaviest stone
            int x = maxHeap.poll(); // Second heaviest stone
            
            if (x != y) {
                maxHeap.offer(y - x); // Put the remaining piece back
            }
        }
        
        // Return the final stone's weight, or 0 if all were destroyed
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}