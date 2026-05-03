class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];

        int i = 0, j = n-1, k = 0;
        while(i <= j){
            int x = Math.abs(nums[i]);
            int y = Math.abs(nums[j]);

            if(x <= y){
                arr[k] = x*x;
                i++;
            }else if(y < x){
                arr[k] = y*y;
                j--;
            }
            k++;
        }
        Arrays.sort(arr);
        return arr;
    }
}