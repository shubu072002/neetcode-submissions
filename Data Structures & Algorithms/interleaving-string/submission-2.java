class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int a = s1.length();
         int b = s2.length();
         int c= s3.length();

         if(a+b!=c){
             return false;
         }
        int[][] dp = new int[a+1][b+1];
         for(int i=0;i<=a;i++){
             for(int j=0;j<=b;j++){
                 dp[i][j]=-1;;
             }
         }
        return helper(s1,s2,s3,0,0,0,dp);
    }
    public boolean helper(String s1, String s2, String s3, int i, int j, int k, int[][] dp){
        // base case 
        if(i==s1.length() && j==s2.length() && k==s3.length()){
            return true;
        }
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        boolean x = false;
        boolean y = false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            x = helper(s1,s2,s3,i+1,j,k+1,dp);
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            y= helper(s1,s2,s3,i,j+1,k+1,dp);
        }
        dp[i][j] = x||y?1:0;
        return x||y;
    }
}
