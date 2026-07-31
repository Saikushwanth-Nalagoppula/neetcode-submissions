class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        List<List<String>> res=new ArrayList<>();
        backtrack(0,board,res);
        return res;
    }
    void backtrack(int row,char[][] board,List<List<String>> res){
        int n=board.length;
        //base case
        if(row==board.length){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }
        //check columns 
        for(int col=0;col<n;col++){
            if(safe(row,col,board)){
                //place
                board[row][col]='Q';
                //explore
                backtrack(row+1,board,res);
                //undo
                board[row][col]='.';
            }
        }
    }
    boolean safe(int row,int col,char[][] board){
         int n = board.length;

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }
    }

