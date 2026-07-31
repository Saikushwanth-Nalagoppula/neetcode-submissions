class Solution {
    public boolean exist(char[][] board, String word) {
        //first we have to find out the character of the given word in the grid
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    //apply the recursion 
                    if(func(i,j,0,board,word,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean func(int i,int j,int index,char[][] board,String word,boolean[][] visited){
        int m=board.length;
        int n=board[0].length;
        if(i<0||i>=m||j<0||j>=n||word.charAt(index)!=board[i][j]||visited[i][j]){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        visited[i][j]=true;
        //so we have 4 directions to go up,down,left,right
        if(func(i-1,j,index+1,board,word,visited) || 
           func(i+1,j,index+1,board,word,visited) || 
           func(i,j-1,index+1,board,word,visited) || 
           func(i,j+1,index+1,board,word,visited)) {
            return true;
        }
        visited[i][j]=false;
        return false;
    }
}