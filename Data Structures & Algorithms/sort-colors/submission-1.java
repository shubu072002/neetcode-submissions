class Solution {
    public void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
        start++;
        end--;
    }
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int idx =0;
        while(idx<=end){
            if(nums[idx]==2){
                swap(nums,idx,end);
                end--;
            }
            else if(nums[idx]==0){
                swap(nums,start, idx);
                start++;
                idx++;
            }
            else{
                idx++;
            }

        }
    }
}