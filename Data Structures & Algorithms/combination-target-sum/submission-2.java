class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, target, new ArrayList<>(), 0);
        return res;
    }
    public void helper(List<List<Integer>> res, int[] nums, int target, List<Integer> sublist, int idx){
        if(target==0){
            res.add(new ArrayList<>(sublist));
            return;
        }
        if(idx==nums.length || target<0){
            return;
        }

        //take same element
        sublist.add(nums[idx]);
        helper(res, nums, target-nums[idx], sublist, idx);
        
        sublist.remove(sublist.size()-1);
        //exclude
        helper(res, nums, target, sublist, idx+1);
    }
}
