class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]>maxSpeed){
                maxSpeed = piles[i];
            }
        }
        while(minSpeed<maxSpeed){
            int mid = minSpeed + (maxSpeed-minSpeed)/2;
            if(canEatInTime(piles,mid,h)){
                maxSpeed = mid;
            }else{
                minSpeed = mid+1;
            }
        }
        return minSpeed;
    }
    public boolean canEatInTime(int[] piles, int mid, int h){
        int hours =0;
        for(int i=0;i<piles.length;i++){
            hours += Math.ceil((double)piles[i]/mid);
        }
        return hours <= h;
    }
}
