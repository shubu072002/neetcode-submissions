class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        int maxLength = 0;
        for(String word: wordDict){
           maxLength = Math.max(word.length(),maxLength);
           set.add(word);
        }
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=Math.max(0,i-maxLength);j--){
                String str = s.substring(j,i);
                if(set.contains(str) && dp[j]==true){
                   dp[i]=true;
                   break;
                }
            }
        }
        return dp[n];
    }
}
