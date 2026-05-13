class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, res, new ArrayList<>());
        return res;
    }
    public void helper(
        int idx, int[] candidates, int target, List<List<Integer>> res, List<Integer> temp) {
        // base case
         if(target<0){
            return;
        }
        if (target == 0) {
             res.add(new ArrayList<>(temp)); 
        }
        for (int i = idx; i < candidates.length; i++) {
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            helper(i + 1, candidates, target - candidates[i], res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
