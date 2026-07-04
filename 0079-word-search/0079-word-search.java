class Solution {
            int[] row = {-1,1,0,0};
        int [] col = { 0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board [0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <m ; j++){

                if(board[i][j] == word.charAt(0)){
                    if(dfs(board , word , i , j , 0)){
                        return true;
                    }
                }
            }
        }
        return false ; 



    
    }
     public boolean dfs(char[][] board, String word, int r, int c, int index){
        if(index == word.length()){
            return true;
        }

        if(r<0 || r>= board.length || c<0 || c>= board[0].length || board [r][c] != word.charAt(index)){
            return false ;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        for(int i = 0 ; i<4 ; i++){
            int newRow = r + row[i];
            int newCol = c + col[i];

            if(dfs(board, word, newRow , newCol , index+1)){
                return true;
            }
        }
        board[r][c] = temp;
        return false;
     }
}