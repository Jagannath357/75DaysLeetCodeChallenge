class Solution {
    // public String getBinary(int n){
    //     return Integer.toBinaryString(n);
    // }
    // public int getTotalSet(int n){
    //     if(n == 0) return 0;
    //     int count = 0;
    //     while(n != 0){
    //         count++;
    //         n &= (n-1);
    //     }
    //     return count;
    // }
    public int[] countBits(int n) {
        int i;
        int arr[] = new int[n+1];
        for(i=0; i<n+1;i++){
            arr[i] = Integer.bitCount(i);
        }
        return arr;
    }
}