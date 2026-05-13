class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0,nums,res,target,new ArrayList<>());
        return res;
    }
    public void helper(int idx, int[] nums,  List<List<Integer>> res, int target, List<Integer> temp){
        // base 
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target<0){
            return;
        }
        if(idx>=nums.length){
            return;
        }
        temp.add(nums[idx]);
        helper(idx,nums,res,target-nums[idx],temp);
         temp.remove(temp.size()-1);

        helper(idx+1,nums,res,target,temp);
       
    }
}
