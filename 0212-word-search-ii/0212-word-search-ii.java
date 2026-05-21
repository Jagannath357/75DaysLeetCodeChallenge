import java.util.ArrayList;
import java.util.List;

class Solution {
    // Trie Node definition
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Stores the complete word if it ends here
    }

    // Build the Trie using the input word list
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode current = root;
            for (char ch : w.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.word = w; // Mark the end of a valid word
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        // Scan every cell of the board as a starting point
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        // Boundary check and visited check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        
        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) return;

        // Move to the next Trie node matched by the current board letter
        node = node.children[ch - 'a'];

        // If we hit a word endpoint, add it to our results
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Prune: Prevent duplicate entries of the same word
        }

        // Mark the current cell as visited
        board[r][c] = '#';

        // Explore 4 adjacent directions: Up, Down, Left, Right
        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);

        // Backtrack: Restore the original character
        board[r][c] = ch;
    }
}