class Solution {
    int n;
    int m;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(helper(r,c,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(int row, int col, int idx, char[][] board, String word){
        if(row<0 || row>=n || col<0 || col>=m || board[row][col]!=word.charAt(idx)){
            return false;
        }
        if(idx==word.length()-1){
            return true;
        }
        char temp = board[row][col];
        board[row][col]='0';
        if(helper(row-1,col,idx+1,board,word)
        || helper(row+1,col,idx+1,board,word)
        || helper(row,col-1,idx+1,board,word)
        || helper(row,col+1,idx+1,board,word)){
            return true;
        }
        board[row][col]=temp;
        return false;
    }
}
