class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        res[0]=nums[dq.peekFirst()];
        for(int i=1;i<n-k+1;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i+k-1]){
                dq.pollLast();
            }
            dq.offerLast(i+k-1);
            res[i]=nums[dq.peekFirst()];
        }
        return res;
    }
}
