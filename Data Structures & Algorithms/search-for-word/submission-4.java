class Solution {
    int n ;
    int m;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i, int j, int idx, char[][] board, String word){
        if(i<0||j<0||i>=n||j>=m||board[i][j]!=word.charAt(idx)){
            return false;
        }
        if(idx==word.length()-1){
            return true;
        }
        char temp = board[i][j];
        board[i][j]='0';
        if(dfs(i-1,j,idx+1,board,word)||
         dfs(i,j+1,idx+1,board,word)||
         dfs(i+1,j,idx+1,board,word)||
         dfs(i,j-1,idx+1,board,word)
        ){
            return true;
        }
        board[i][j]= temp;
        return false;
    }
}
