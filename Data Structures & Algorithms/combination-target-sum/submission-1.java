class Solution {
      public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,candidates,target,0,new ArrayList<>());
        return ans;
    }
    public void helper(List<List<Integer>> ans, int[] nums, int target, int index, List<Integer> sublist){
        //base case
        if(index==nums.length || target<0){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(sublist));
            return;
        }
        //take same elements
        sublist.add(nums[index]);
        helper(ans,nums,target-nums[index],index,sublist);
        
        //backtrack
        sublist.remove(sublist.size()-1);

        helper(ans,nums,target,index+1,sublist);
        
    }
}