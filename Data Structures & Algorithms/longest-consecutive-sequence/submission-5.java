class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<n;i++){
            int element = nums[i];
            int length = 1;
            int prev = element - 1;
            while(set.contains(prev)){
                length++;
                prev = prev - 1;
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
