class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=1;i<=n;i++){
            res[i]=getCountBits(i);
        }
        return res;
    }
    public int getCountBits(int num){
        int count =0;
        while(num!=0){
            count++;
            num = num & (num-1);
        }
        return count;
    }
}
