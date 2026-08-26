class Solution {
    public boolean canEatBanana(int[] piles,int speed, int h){
        int hour=0;
        for(int pile: piles){
            hour+= (int)Math.ceil((double)pile/speed);
        }
        return hour<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed =0;
        for(int pile: piles){
            maxSpeed=Math.max(maxSpeed, pile);
        }
        while(minSpeed<maxSpeed){
            int mid = minSpeed + (maxSpeed-minSpeed)/2;
            if(canEatBanana(piles,mid,h)){
                maxSpeed = mid;
            }
            else
            {
                minSpeed = mid + 1;
            }
        }
        return maxSpeed;
    }
}
