class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return helper(res, nums, new ArrayList<>()); 
    }
    private List<List<Integer>> helper(List<List<Integer>> res, int[] nums, List<Integer> temp){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
        }
        for(int element: nums){
             if(temp.contains(element)){
                continue;
             }

            //add to temp list
            temp.add(element);

            //call
            helper(res,nums,temp);

            //backtrack
            temp.remove(temp.size()-1);
        }
        return res;
    }
}
