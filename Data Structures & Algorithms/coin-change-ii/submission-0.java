class Solution {
    public int change(int amount, int[] coins) {
       Integer[][] dp = new Integer[coins.length][amount + 1];
        return helper(amount, coins, 0, dp);
    }
    public int helper(int amount, int[] coins, int index,  Integer[][] dp ){
         String key = amount + "coins" + index;
        if(index>= coins.length || amount<0){
            return 0;
        }
        if(amount==0){
            return 1;
        }
        if(dp[index][amount]!=null){
            return dp[index][amount];
        }
        int x = helper(amount-coins[index], coins, index, dp );
        int y = helper(amount, coins, index+1, dp );
        return dp[index][amount] = x + y;
    }
}
