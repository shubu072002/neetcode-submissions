class Number implements Comparable<Number>{
    int element;
    int freq;
    Number(int element, int freq){
        this.element = element;
        this.freq = freq;
    }
    public int compareTo(Number that){
        return this.freq - that.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      HashMap<Integer,Integer> map = new HashMap<>();
      PriorityQueue<Number> pq = new PriorityQueue<>();
      for(int i=0;i<nums.length;i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
      }  
      for(Map.Entry<Integer,Integer> elem: map.entrySet()){
         pq.offer(new Number(elem.getKey(),elem.getValue()));
         if(pq.size()>k){
            pq.poll();
         }
      }
      int[] res = new int[k];
      for(int i=0;i<k;i++){
        Number number=pq.poll();
        res[i]=number.element;
      }
      return res;
    }
}
