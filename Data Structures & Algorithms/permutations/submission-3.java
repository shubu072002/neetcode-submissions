class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,res,new ArrayList<>());
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> temp){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            helper(nums, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}
