class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n){
            if(nums[i] > nums[n-1]){
                i++;
            }else{
                return nums[i];
            }
        }
        return -1;
    }
}