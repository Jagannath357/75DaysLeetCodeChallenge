import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Cache to store the reversed value of 8-bit chunks (0 to 255)
    private final int[] cache = new int[256];

    public Solution() {
        // Precompute the reverse for all 8-bit integers
        for (int i = 0; i < 256; i++) {
            cache[i] = reverse8Bits(i);
        }
    }

    private int reverse8Bits(int n) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }
        return res;
    }

    public int reverseBits(int n) {
        // Split the 32-bit int into 4 bytes, look them up, and reassemble them in reverse order
        return (cache[n & 0xFF] << 24) | 
               (cache[(n >>> 8) & 0xFF] << 16) | 
               (cache[(n >>> 16) & 0xFF] << 8) | 
               (cache[(n >>> 24) & 0xFF]);
    }
}