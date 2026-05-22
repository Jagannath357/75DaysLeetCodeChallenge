import java.util.PriorityQueue;

class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        // Populate the heap with the initial stream of scores
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        // Push the new score onto our heap
        minHeap.offer(val);
        
        // If our heap holds more than k items, discard the lowest score
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        
        // The root of our min-heap is the smallest of the k-largest elements,
        // which mathematically makes it the k-th largest overall.
        return minHeap.peek();
    }
}