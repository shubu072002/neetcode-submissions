class Solution {
    class Number implements Comparable<Number>{
        int element;
        int freq;
        Number(int element, int freq){
            this.element=element;
            this.freq=freq;
        }

        public int compareTo(Number that){
            return this.freq - that.freq;
        }    
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Number> pq = new  PriorityQueue<>();
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
           Number number = new Number(e.getKey(),e.getValue());
            pq.offer(number);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            Number number = pq.poll();
            ans[i]=number.element;
        }
       return ans;
    }
}
