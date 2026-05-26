class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startingColor = image[sr][sc];
        
        // If the starting pixel already has the target color, no work is needed.
        if (startingColor != color) {
            dfs(image, sr, sc, startingColor, color);
        }
        
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int startingColor, int newColor) {
        // Boundary check and color match check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != startingColor) {
            return;
        }
        
        // Update the color of the current pixel
        image[r][c] = newColor;
        
        // Recursively look in all 4 directions
        dfs(image, r + 1, c, startingColor, newColor); // Down
        dfs(image, r - 1, c, startingColor, newColor); // Up
        dfs(image, r, c + 1, startingColor, newColor); // Right
        dfs(image, r, c - 1, startingColor, newColor); // Left
    }
}