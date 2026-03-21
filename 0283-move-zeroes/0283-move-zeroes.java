class Solution {
    public void moveZeroes(int[] nums) {
        int i,j = 0;
        int n = nums.length;
        for(i=0;i<n;i++){
            if(nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        while(j<n){
            nums[j++] = 0;
        }
    }
}