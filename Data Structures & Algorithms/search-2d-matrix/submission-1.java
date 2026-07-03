class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = searchPotentialrow(matrix, target);
        if(rowIdx!=-1){
            return binarySearch(matrix, target, rowIdx);
        }
        else{
            return false;
        }
    }
    public boolean binarySearch(int[][] matrix, int target, int rowIdx){
        int start = 0;
        int end = matrix[0].length;
        while(start<=end){
             int mid = start + (end-start)/2;

             if(matrix[rowIdx][mid]==target){
                return true;
             }
             else{
                if(matrix[rowIdx][mid]<target){
                    start = mid +1;
                }
                else{
                    end = mid -1;
                }
             }
           
        }
          return false;
    }
    public int searchPotentialrow(int[][] matrix, int target){
        int start =0;
        int end = matrix.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(matrix[mid][0]<=target && target<=matrix[mid][matrix[0].length-1]){
                return mid;
            }
            else if (matrix[mid][0]<target){
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }
        return -1;
    }
}
