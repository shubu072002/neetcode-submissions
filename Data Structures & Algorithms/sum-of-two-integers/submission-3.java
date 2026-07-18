class Solution {
    public int getSum(int a, int b) {
        int sum = a^b;
        int carry = a&b;
        while(carry!=0){
            int actualcarry = carry<<1;
            carry=sum & actualcarry;
            sum=sum ^ actualcarry;
        }
        return sum;
    }
}
