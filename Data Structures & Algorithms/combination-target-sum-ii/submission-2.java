class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(0, candidates, new ArrayList<>(), res, target);
        return res;
    }
     public void helper(int index, int[] nums, List<Integer> curr, List<List<Integer>> res, int target) {
        if(target<0){
            return;
        }
        if(target==0){
          res.add(new ArrayList<>(curr));
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            helper(i + 1, nums, curr, res, target-nums[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
