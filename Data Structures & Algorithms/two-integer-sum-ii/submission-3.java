class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int start=0;
        int end =n-1;
        while(start<end){
            int sum = numbers[start]+numbers[end];
            if(sum>target){
                end--;
            }
            else if (sum<target){
                start++;
            }
            else{
                return new int[]{start+1,end+1};
            }
        }
        return new int[]{};
    }
}
