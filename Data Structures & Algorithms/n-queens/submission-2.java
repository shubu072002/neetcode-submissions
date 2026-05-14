class Solution {
    public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    List<List<String>> res = new ArrayList<>();
    helper(res,board,0);
    return res;
    }
    public void helper(List<List<String>> res,char[][] board , int col ){
        // base case 
        if(col==board.length){
            saveBoard(res,board);
            return;
        }
        for(int row=0;row<board.length;row++){
           if(isvalid(board,row,col)){
            board[row][col]='Q';
            helper(res,board,col+1);
            board[row][col]='.';
           }
        }
    }
    public void saveBoard(List<List<String>> res,char[][] board ){
        List<String> sublist = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String str ="";
            for(int j=0;j<board[0].length;j++){
              if(board[i][j]=='Q'){
                str+=board[i][j];
              }else{
                str+='.';
              }
            }
            sublist.add(str);
        }
        res.add(new ArrayList<>(sublist));
    }
    public boolean isvalid(char[][] board, int row, int col){
        //horizontal
        for(int i=0;i<col;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }

        // upper left
        int r = row;
        for(int c=col;c>=0 && r>=0;r--,c--){
           if(board[r][c]=='Q'){
                return false;
            }  
        }

        //lower left
        r = row;
        for(int c=col;c>=0 && r<board.length;c--,r++){
             if(board[r][c]=='Q'){
                return false;
            }   
        }
        return true;
    }
}
