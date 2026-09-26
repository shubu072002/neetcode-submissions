class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates); 
       List<List<Integer>> result = new ArrayList<>();
       helper(0,candidates,result,target,new ArrayList<>());
       return result; 
    }
    public void helper(int idx , int[] nums, List<List<Integer>> result, int target, List<Integer> temp){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(temp));
        }
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            helper(i+1,nums,result,target-nums[i],temp);
            temp.remove(temp.size()-1);
        }
    }
}
