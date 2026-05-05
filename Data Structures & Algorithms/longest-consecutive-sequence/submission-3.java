class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
      int max =Integer.MIN_VALUE;
      for(int i=0;i<nums.length;i++){
          set.add(nums[i]);
      }
      for(int element: set){
          int curEle = element;
          int prev = element-1;
          if(!set.contains(prev)){
              int length =1;
              int nextEle = element+1;
              while(set.contains(nextEle)){
                  nextEle++;
                  length++;
              }
              max= Math.max(max, length);
          }
      }
      return max; 
    }
}
