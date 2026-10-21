class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        // tranpose kar dia jo mera row tha usko col bana dia 
        for(int i=0;i<n;i++){
            for(int j =i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // reverse each row
        for(int i=0;i<n;i++){
            int start =0; 
            int end = n-1;
            while(start<end){
                int temp = matrix[i][start];
                matrix[i][start]=matrix[i][end];
                matrix[i][end]=temp;
                start++;
                end--;
            }
        }
    }
}
