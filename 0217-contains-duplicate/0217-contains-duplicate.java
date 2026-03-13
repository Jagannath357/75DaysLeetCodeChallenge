class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinct = new HashSet<>();

        int i;
        for(i = 0; i < nums.length; i++){
            if(distinct.contains(nums[i])){
                return true;
            }
            else{
                distinct.add(nums[i]);
            }
        }
        return false;
    }

}