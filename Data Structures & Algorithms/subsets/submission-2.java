class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
        helper(0,nums,result,new ArrayList<>()); 
        return result;
    }
    public void helper(int idx, int[] nums, List<List<Integer>> result, List<Integer> temp){
        result.add(new ArrayList<>(temp));
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            helper(i+1,nums,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}
