class Solution {
    public int getSum(int a, int b) {
        int carry = a&b;
        int sumwithoutcarry=a^b;
        int actaulcarry = carry<<1;
        while(carry!=0){
            carry = sumwithoutcarry & actaulcarry;
            sumwithoutcarry =sumwithoutcarry ^ actaulcarry;
            actaulcarry = carry<<1;
        }
        return sumwithoutcarry;
    }
}
