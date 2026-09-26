class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result  = new ArrayList<>();
        helper(0,nums,result,target,new ArrayList<>());
        return result;
    }
    public void helper(int idx, int[] nums, List<List<Integer>> result, int target, List<Integer> temp){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target<0 || idx==nums.length){
           return;
        }
        //take
        temp.add(nums[idx]);
        helper(idx,nums,result,target-nums[idx],temp);
        temp.remove(temp.size()-1);

        //not take
        helper(idx+1,nums,result,target,temp);

    }
}
