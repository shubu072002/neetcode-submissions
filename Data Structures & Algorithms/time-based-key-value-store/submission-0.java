class TimeStampedValue{
    String value;
    int timeStamp;

    public TimeStampedValue(String value,int timeStamp ){
         this.value = value;
         this.timeStamp = timeStamp;
    }
}
class TimeMap {

    HashMap<String, ArrayList<TimeStampedValue>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       if(!map.containsKey(key)){
        map.put(key,new ArrayList<>());
       } 
       ArrayList<TimeStampedValue> list=map.get(key);
       list.add(new TimeStampedValue(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
       ArrayList<TimeStampedValue> list = map.get(key);
       TimeStampedValue curr = binarySearch(list,timestamp);
       if(curr==null){
        return "";
       }
       return curr.value;
    }
    public TimeStampedValue binarySearch( ArrayList<TimeStampedValue> list, int target){
        int left =0;
        int right = list.size()-1;
        int matchIdx = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            TimeStampedValue curr = list.get(mid);
            if(curr.timeStamp<=target){
                matchIdx = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(matchIdx==-1){
            return null;
        }
        return list.get(matchIdx);

    }
}
