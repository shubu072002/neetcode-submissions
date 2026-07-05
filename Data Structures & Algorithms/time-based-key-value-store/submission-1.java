class TimeStampedValue {
    int timeStamp;
    String value;

    TimeStampedValue(int timeStamp, String value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}
class TimeMap {
    HashMap<String, ArrayList<TimeStampedValue>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        ArrayList<TimeStampedValue> list = map.get(key);
        list.add(new TimeStampedValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        ArrayList<TimeStampedValue> list = map.get(key);
        TimeStampedValue timeStampedValue = binarySearch(list, timestamp);
        if (timeStampedValue == null) {
            return "";
        }
        return timeStampedValue.value;
    }
    public TimeStampedValue binarySearch(ArrayList<TimeStampedValue> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int matchidx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            TimeStampedValue curr = list.get(mid);
            if (curr.timeStamp <= target) {
                matchidx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (matchidx == -1) {
            return null;
        }
        return list.get(matchidx);
    }
}
