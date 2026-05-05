class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return helper(s, p, 0, 0, dp);
    }

    public boolean helper(String s, String p, int i, int j, Boolean[][] dp) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean match = (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        boolean x = false;
        boolean y = false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            x = helper(s, p, i, j + 2, dp);
            y = match && helper(s, p, i + 1, j, dp);
            return dp[i][j] = x || y;
        } else {
            return dp[i][j] = match && helper(s, p, i + 1, j + 1, dp);
        }
    }
}