class Solution {
    int row;
    int col;
    int[][] mat;
    int max = 0;

    private int bfs(int r, int c){
        if(mat[r][c] == 0){
            return 0;
        }
        else{
            int ret = 1;
            mat[r][c] = 0;
            if(r > 0){
                ret += bfs(r - 1, c);
            }
            if(c > 0){
                ret += bfs(r, c - 1);
            }
            if(r < row - 1){
                ret += bfs(r + 1, c);
            }
            if( c < col - 1){
                ret += bfs(r, c + 1);
            }
            return ret;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.mat = grid;
        this.row = grid.length;
        this.col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 1){
                    max = Math.max(bfs(i, j), max);
                }
            }
        }
        return max;
    }
}
