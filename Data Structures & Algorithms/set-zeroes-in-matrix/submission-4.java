class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRowZeros = false;
        boolean firstColZeros = false;

        for(int col=0;col<m;col++){
            if(matrix[0][col]==0){
                firstRowZeros = true;
                break;
            }
        }

        for(int row=0;row<n;row++){
            if(matrix[row][0]==0){
                firstColZeros = true;
                break;
            }
        }

        //set markers
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        // traverse and make zeros
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRowZeros){
            for(int col=0;col<m;col++){
            matrix[0][col]=0;
        }
        }
        if(firstColZeros){
            for(int row=0;row<n;row++){
            matrix[row][0]=0;
        }
        }

    }
}
