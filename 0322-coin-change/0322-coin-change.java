import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        // Base case: If amount is 0, we need 0 coins
        if (amount == 0) return 0;
        
        // Create a DP array to store the fewest coins for each amount
        // dp[i] will hold the minimum coins needed for amount i
        int[] dp = new int[amount + 1];
        
        // Fill the array with a placeholder "max" value (amount + 1)
        // We don't use Integer.MAX_VALUE to avoid integer overflow when adding 1
        Arrays.fill(dp, amount + 1);
        
        // Base case initialization
        dp[0] = 0;
        
        // Build up solutions for every amount from 1 to 'amount'
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // If the coin value is less than or equal to the current sub-amount
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still greater than amount, it means it's unreachable
        return dp[amount] > amount ? -1 : dp[amount];
    }
}