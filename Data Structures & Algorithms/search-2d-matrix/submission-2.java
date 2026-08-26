class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left =0;
        int right = m-1;
        int validRow = potentialRow(matrix,target);
        if(validRow==-1){
            return false;
        }
        else{
           while(left<=right){
             int mid = left + (right-left)/2;
             if(matrix[validRow][mid]==target){
                return true;
             }
             else if(matrix[validRow][mid]<target){
                left = mid + 1;
             }
             else{
                right = mid -1;
             }
           }
        }
         return false;
    }
    public int potentialRow(int[][] matrix, int target){
        int left = 0;
        int right = matrix.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>=target){
               return mid;
            }
            else if(matrix[mid][0]<target){
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        return -1;
    }
}
