class Solution {
    class Number implements Comparable<Number>{
        int element;
        int freq;
        public Number(int element, int freq){
            this.element = element;
            this.freq = freq;
        }
        public int compareTo(Number that){
            //min heap
          return this.freq - that.freq;   
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int element: nums){
            map.put(element, map.getOrDefault(element,0)+1);
        }
        PriorityQueue<Number> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            Number number = new Number(e.getKey(), e.getValue());
            pq.offer(number);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        int i=0;
        while(i<k){
          Number number = pq.poll();
          ans[i] = number.element;
          i++;
        }
        return ans;
        
    }
}
