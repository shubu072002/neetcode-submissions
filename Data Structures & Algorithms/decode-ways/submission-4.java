class Solution {
    public int numDecodings(String s) {
       int n = s.length();
       int[] dp = new int[n+1];
       dp[0]=1;
       dp[1]=s.charAt(0)=='0'?0:1;
       for(int i=2;i<=n;i++){
        int singledigit = Integer.parseInt(s.substring(i-1,i));
        int doubledigit = Integer.parseInt(s.substring(i-2,i));
        if(singledigit!=0 && singledigit<=9){
            dp[i]+=dp[i-1];
        }
        if(doubledigit<=26 && doubledigit>9){
            dp[i]+=dp[i-2];
        }
       }
       return dp[n];
    }
}
