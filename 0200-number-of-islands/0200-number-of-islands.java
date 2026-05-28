class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;

        // Traverse every cell in the 2D grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If a piece of land ('1') is found, it's a new island
                if (grid[i][j] == '1') {
                    islandCount++;
                    // Use DFS to sink the entire connected island
                    dfs(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c) {
        // Boundary checks and water check
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // Sink the current cell to mark it as visited
        grid[r][c] = '0';

        // Recursively visit all 4 neighboring directions
        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
    }
}