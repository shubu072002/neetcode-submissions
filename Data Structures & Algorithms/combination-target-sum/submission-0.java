class Solution {
      public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,candidates,target,0,new ArrayList<>(), new HashSet<>());
        return ans;
    }
    public void helper(List<List<Integer>> ans, int[] nums, int target, int index, List<Integer> sublist, HashSet<List<Integer>> set){
        //base case
        if(index==nums.length || target<0){
            return;
        }
        if(target==0){
            if(!set.contains(sublist)){
                ans.add(new ArrayList<>(sublist));
                set.add(new ArrayList<>(sublist));
            }
            return;
        }
        //single take elements
        sublist.add(nums[index]);
        helper(ans,nums,target-nums[index],index+1,sublist, set);
        // multiple take elements of same type
        helper(ans,nums,target-nums[index],index,sublist, set);
        
        //backtrack
        sublist.remove(sublist.size()-1);

        helper(ans,nums,target,index+1,sublist, set);
        
    }
}
