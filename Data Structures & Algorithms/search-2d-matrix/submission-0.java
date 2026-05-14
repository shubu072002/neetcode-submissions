class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int rowIdx = searchPotentialRow(matrix, target);
       if(rowIdx!=-1){
        return binarySearch(matrix,target,rowIdx);
       } else{
        return false;
       }
    }
    public boolean binarySearch(int[][] matrix, int target, int rowIdx){
        int low =0;
        int high = matrix[0].length;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(matrix[rowIdx][mid]==target){
                return true;
            }
            else if(matrix[rowIdx][mid]<target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return false;
    }
    public int searchPotentialRow(int[][] matrix, int target){
        int low =0;
        int high = matrix.length-1;
        while(low<=high){
           int mid = low + (high-low)/2;
           if(matrix[mid][0]<=target && target <= matrix[mid][matrix[0].length-1]){
            return mid;
           }
           else if(matrix[mid][0]<target){
            low = mid +1;
           }
           else{
            high = mid-1;
           }
        }
        return -1;
    }
}
