class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(0,candidates,target,res,new ArrayList<>());
        return res;
    }
    public void helper(int idx, int[] nums, int target, List<List<Integer>> res, List<Integer> temp){
        if(target<0){
            return;
        }
        if(target==0){
            res.add((new ArrayList<>(temp)));
        }
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            helper(i+1,nums, target-nums[i], res, temp);
            temp.remove(temp.size()-1);
        }
    }
}
