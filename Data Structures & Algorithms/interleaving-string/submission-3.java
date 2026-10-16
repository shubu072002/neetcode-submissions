class Solution {
    int l1 ;
    int l2;
    int l3;
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        l1=s1.length();
        l2=s2.length();
        l3=s3.length();
        if((l1+l2)!=l3){
            return false;
        }
        dp= new int[l1+2][l2+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,0,0,s1,s2,s3);
    }
    public boolean helper(int i, int j , int k, String s1, String s2, String s3){
        if(i==l1 && j==l2 && k==l3){
            return true;
        }
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        boolean x = false;
        boolean y = false;

        if(i<l1 && s1.charAt(i)==s3.charAt(k)){
            x= helper(i+1,j,k+1,s1,s2,s3);
        }
        if(j<l2 && s2.charAt(j)==s3.charAt(k)){
            y= helper(i,j+1,k+1,s1,s2,s3);
        }

        dp[i][j] =  x||y?1:0;
        return x||y;
    
    }
}
