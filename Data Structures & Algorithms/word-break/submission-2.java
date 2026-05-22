class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        int maxLength = 0;
        for(String str: wordDict){
          maxLength = Math.max(maxLength,str.length()); 
        }
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
           for(int j=i-1;j>=Math.max(0,i-maxLength);j--){
             if(dp[j] && set.contains(s.substring(j,i))){
                dp[i]=true;
                break;
             }
           }
        }
        return dp[n];

    }
}
