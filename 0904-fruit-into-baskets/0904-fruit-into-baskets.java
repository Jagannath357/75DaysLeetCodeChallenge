import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        // Map to store fruit type and its frequency in the current window
        Map<Integer, Integer> baskets = new HashMap<>();
        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            // Add the current fruit to the basket
            int currentFruit = fruits[right];
            baskets.put(currentFruit, baskets.getOrDefault(currentFruit, 0) + 1);

            // If we have more than 2 types of fruit, shrink the window from the left
            while (baskets.size() > 2) {
                int leftFruit = fruits[left];
                baskets.put(leftFruit, baskets.get(leftFruit) - 1);
                
                // If a fruit count reaches zero, remove it from the baskets
                if (baskets.get(leftFruit) == 0) {
                    baskets.remove(leftFruit);
                }
                left++;
            }

            // The window [left, right] contains at most 2 types of fruit
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}