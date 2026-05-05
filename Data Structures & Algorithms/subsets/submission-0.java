class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0, new ArrayList<>());
        return res;
    }
    public void helper(List<List<Integer>> res, int[] nums, int idx, List<Integer> sublist){
     //Base case 
     if(idx==nums.length){
        res.add(new ArrayList<>(sublist));
        return;
     }
     //pick case 
     sublist.add(nums[idx]);
     helper(res, nums, idx+1, sublist);
     
     // backtrack
     sublist.remove(sublist.size()-1);

     //not pick case
     helper(res, nums, idx+1, sublist);
    }
}
