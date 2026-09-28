class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(0,res,board);
        return res;
    }
    public void helper(int col, List<List<String>> res, char[][] board){
        if(col==board.length){
            saveboard(res,board);
            return;
        }
        for(int row=0;row<board.length;row++){
            if(isValid(board,row,col)){
                board[row][col]='Q';
                helper(col+1,res,board);
                board[row][col]='.';
            }
        }
    }
    public void saveboard(List<List<String>> res, char[][] board){
        List<String> temp = new ArrayList<>();
        for(int r=0;r<board.length;r++){
            String str = "";
            for(int c=0;c<board.length;c++){
                if(board[r][c]=='Q'){
                    str+='Q';
                }
                else{
                    str+='.';
                }
            }
            temp.add(str);
        }
        res.add(new ArrayList<>(temp));
    }
    public boolean isValid(char[][] board, int row, int col){
        //left to right
        for(int c=0;c<board.length;c++){
            if(board[row][c]=='Q'){
                return false;
            }
        }

        int r = row;
        for(int c=col;c>=0 && r>=0;c--,r--){
            if(board[r][c]=='Q'){
                return false;
            }
        }

        r = row;
        for(int c=col;c>=0 && r<board.length;c--,r++){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        return true;
    }
}
