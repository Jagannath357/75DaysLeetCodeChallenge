class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int i, j;
        int[] ans = new int[n1];
        for (i = 0; i < n1; i++) {
            int key = nums1[i], idx = -1, max = -1;
            // System.out.println("Key: "+key);
            for (j = 0; j < n2; j++) {
                if (key == nums2[j]){
                    idx = j;
                    // System.out.println("1st Inner loop: "+idx);
                    break;
                }
            }
            if (idx != -1 && idx < n2) {
                for (j = idx+1; j < n2; j++) {
                    if (nums2[idx] < nums2[j]){
                        ans[i] = nums2[j];
                        max = nums2[j];
                        // System.out.println("2nd Inner Loop: "+ans[i]+"  "+ nums2[j]+"  "+max);
                        break;
                    }
                }
                if(max == -1) 
                    ans[i] = -1;
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
}