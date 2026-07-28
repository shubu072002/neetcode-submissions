class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        for (int card : hand) {
            if (!map.containsKey(card)) {
                continue;
            }
            int currcard = card;
            while (map.containsKey(currcard - 1)) {
                currcard--;
            }
            for (int i = 0; i < groupSize; i++) {
                int carde = currcard + i;
                if (!map.containsKey(carde)) {
                    return false;
                }
                map.put(carde, map.get(carde) - 1);
                if (map.get(carde) == 0) {
                    map.remove(carde);
                }
                if(map.isEmpty()){
                    return true;
                }
            }
        }
        return true;
    }
}
