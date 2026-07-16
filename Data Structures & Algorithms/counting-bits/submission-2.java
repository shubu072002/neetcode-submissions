class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        arr[0]=0;
        for(int i=1;i<arr.length;i++){
            arr[i]=getbit(i);
        }
        return arr;
    }
    public int getbit(int n){
        int count =0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
