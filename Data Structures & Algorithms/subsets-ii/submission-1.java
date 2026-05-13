class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,nums,res,new ArrayList<>());
        return res;
    }
    public void helper(int idx, int[] nums, List<List<Integer>> res, List<Integer> temp){
        res.add(new ArrayList<>(temp));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            helper(i+1,nums,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
