class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int sr = 0;
        int er = n-1;
        int sc = 0;
        int ec = m-1;
        List<Integer> res = new ArrayList<>();
        while(sr<=er && sc<=ec){
            for(int i=sc;i<=ec;i++){
                res.add(matrix[sr][i]);
            }
            sr+=1;
            for(int j=sr;j<=er;j++){
                res.add(matrix[j][ec]);
            }
            ec-=1;
            if(sr<=er){
                for(int i=ec;i>=sc;i--){
                    res.add(matrix[er][i]);
                }
                er-=1;
            }
            if(sc<=ec){
                for(int j=er;j>=sr;j--){
                    res.add(matrix[j][sc]);
                }
            }
            sc+=1;
        }
        return res;
    }
}
