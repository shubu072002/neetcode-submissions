


class Solution {
   public void saveBoard(char[][] board, List<List<String>> res){
        List<String> sublist = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String str = "";
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='Q'){
                    str += board[i][j];
                }
                else{
                    str += '.';
                }
            }
            sublist.add(str);
        }
        res.add(new ArrayList<>(sublist));
    }
    public boolean isvalid(int row, int col, char[][] board){
        //horizontal check
        for(int i=0;i<=col;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        //upper left
         int r = row;
        for(int c=col;c>=0 && r>=0; c--, r--){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        //lower left
         r = row;
        for(int c=col;c>=0 && r<board.length; c--, r++){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        
        return true;
        
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(res, 0, board);
        return res;
    }
    public void helper(List<List<String>> res, int col,  char[][] board ){
        // base case
        if(col==board.length){
            saveBoard(board, res);
            return;
        }
        for(int row=0;row<board.length;row++){
            if(isvalid(row,col, board)){
                board[row][col]='Q';
                helper(res, col+1, board);
                board[row][col] = '.';
            }
        }
    }
}
