import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificReached = new boolean[m][n];
        boolean[][] atlanticReached = new boolean[m][n];

        // Step 1: Start DFS from Top and Bottom borders
        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, Integer.MIN_VALUE, pacificReached);     // Top border (Pacific)
            dfs(heights, m - 1, c, Integer.MIN_VALUE, atlanticReached); // Bottom border (Atlantic)
        }

        // Step 2: Start DFS from Left and Right borders
        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, Integer.MIN_VALUE, pacificReached);     // Left border (Pacific)
            dfs(heights, r, n - 1, Integer.MIN_VALUE, atlanticReached); // Right border (Atlantic)
        }

        // Step 3: Find cells that can reach both oceans
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacificReached[r][c] && atlanticReached[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, int previousHeight, boolean[][] reached) {
        // Boundary check
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length) {
            return;
        }

        // If we already visited this cell from the current ocean, or if the water 
        // cannot flow "upstream" (current height is lower than previous height)
        if (reached[r][c] || heights[r][c] < previousHeight) {
            return;
        }

        // Mark current cell as reachable from this specific ocean
        reached[r][c] = true;

        // Recursively flow upstream to all 4 neighboring directions
        dfs(heights, r + 1, c, heights[r][c], reached); // Down
        dfs(heights, r - 1, c, heights[r][c], reached); // Up
        dfs(heights, r, c + 1, heights[r][c], reached); // Right
        dfs(heights, r, c - 1, heights[r][c], reached); // Left
    }
}