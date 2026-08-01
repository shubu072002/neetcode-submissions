class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
         helper(0,nums,target,res,new ArrayList<>());
         return res;
    }
    public void helper(int idx, int[] nums, int target, List<List<Integer>> res, List<Integer> temp){
       if(target<0){
        return;
       } 
       if(target==0){
        res.add(new ArrayList<>(temp));
        return;
       }
       if(idx>=nums.length){
        return;
       }
       temp.add(nums[idx]);
       helper(idx,nums,target-nums[idx],res,temp);
       temp.remove(temp.size()-1);

        helper(idx+1,nums,target,res,temp);

    }
}
