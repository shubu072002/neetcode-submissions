class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0,res,nums,new ArrayList<>(),target);
        return res;
    }
    public void helper(int index, List<List<Integer>> res, int[] nums,List<Integer> sublist, int target){
        if(index==nums.length || target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(sublist));
            return;
        }

        // take same element - case 1 
        sublist.add(nums[index]);
        helper(index,res,nums,sublist,target-nums[index]);
        //while backtrack
        sublist.remove(sublist.size()-1);

        // exclude the curr element
        helper(index+1,res,nums,sublist,target);
    }
}
