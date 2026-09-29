class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int max = 0;
        for(int num: set){
            int prev = num-1;
            if(!set.contains(prev)){
                int  length = 1;
                int nextElement = num+1;
                while(set.contains(nextElement)){
                    length++;
                    nextElement++;
                } 
                max = Math.max(max,length);
            }
        }
        return max ;
    }
}
