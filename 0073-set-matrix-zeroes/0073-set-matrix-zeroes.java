class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int [n];
        int[] col = new int [m];

        Arrays.fill(row, -1);
        Arrays.fill(col,-1);

        //Marks that rows and columns that should be set to zero
        for(int i = 0 ; i<n;i++){
            for(int j = 0 ; j<m ; j++){
                if(matrix[i][j]==0){
                    row[i] = 0;
                    col[j]=0;
                }
            }
        }

        //set corresponding elements to zero 
        for(int i = 0 ; i<n ;i++){
            for(int j = 0 ; j<m ; j++){
                if((row[i]==0 || col[j]==0)&& matrix[i][j] != 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}