class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i, j, idx;
        int n = numbers.length;
        if (n == 0) return new int[]{};
        for (i = 0; i < n; i++) {
            if (numbers[i] > target)
                idx = i - 1;
        }
        i = 0;
        j = n-1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target)
                return new int[] { i + 1, j + 1 };
            else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{};
    }
}