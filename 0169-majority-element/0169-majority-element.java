class Solution {
    public int majorityElement(int[] nums) {
        List<Integer> al = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i;
        for(i = 0; i < nums.length; i++){
            if(!al.contains(nums[i])){
                al.add(nums[i]);
                hm.put(nums[i], 1);
            }else{
                int val = hm.get(nums[i]);
                hm.replace(nums[i], val+1);
            }
        }
        int max = 0, maxEle = 0;
        for(i = 0; i < al.size(); i++){
            if(hm.get(al.get(i)) > max){
                max = hm.get(al.get(i));
                maxEle = al.get(i);
            }
        }
        return maxEle;
    }
}