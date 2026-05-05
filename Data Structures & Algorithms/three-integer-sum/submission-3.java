class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[j] + nums[k] + nums[i];
                if(sum==0){
                    List<Integer> sublist = new ArrayList<>();
                    sublist.add(nums[i]);
                    sublist.add(nums[j]);
                    sublist.add(nums[k]);
                    ans.add(sublist);

                while( j<k && nums[j+1]==nums[j]){
                  j++;
                }
                while(j<k && nums[k-1]==nums[k]){
                  k--;
                }
                j++;
                k--;
            }
                else {
                    if(sum<0){
                    j++;
                    }
                    else{
                     k--;
                    }
                }
            }
        }
        return ans;
    }
}
