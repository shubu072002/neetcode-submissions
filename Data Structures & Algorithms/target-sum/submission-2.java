class Solution {
    int n ;
    HashMap<String, Integer> map ;
    public int findTargetSumWays(int[] nums, int target) {
        n=nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        map = new HashMap<>();
        return helper(0,0,nums,target);
    }
    public int helper(int idx, int sum, int[] nums, int target){
        if(idx==n && sum==target){
            return 1;
        }
        if(idx==n){
            return 0;
        }

        String key = idx + "," + sum;
        if(map.containsKey(key)){
            return map.get(key);
        }
       
        int x = 0;
        int y =0;
        x= helper(idx+1,sum+nums[idx],nums,target);
        y = helper(idx+1, sum-nums[idx], nums, target);

        map.put(key, x+y);
        return x+y;
    }
}
