class Solution {
    public int[] countBits(int n) {
        int i;
        int arr[] = new int[n+1];
        for(i=0; i<n+1;i++){
            arr[i] = Integer.bitCount(i);
        }
        return arr;
    }
}