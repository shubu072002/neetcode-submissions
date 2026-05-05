class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String,Integer> map = new HashMap<>();
        return helper(0,0, prices,map);
    }
    //0- means purchase 
    //1- means sales 
    public int helper(int index, int buyOrSell,int[] prices,  HashMap<String,Integer> map ){
        //basecase 
        if(index>=prices.length){
            return 0;
        }
        String key = index + "shares" + buyOrSell;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int maxProfit = 0;
        if(buyOrSell == 0){
            int buy = helper(index+1, 1, prices, map)-prices[index];
            int nobuy =helper(index+1,0, prices, map);
            maxProfit = Math.max(buy, nobuy);
        }else{
            int sell = helper(index+2,0, prices, map)+prices[index];
            int nosell = helper(index+1,1, prices, map);
            maxProfit= Math.max(sell, nosell);
        }
        map.put(key, maxProfit);
        return maxProfit;
    }
}