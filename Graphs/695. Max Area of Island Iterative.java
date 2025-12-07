class Solution {
    int row;
    int col;
    int[][] mat;
    int max = 0;

    private int dfs(int r, int c){
        
        int ret = 1;
        mat[r][c] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            r = tmp[0];
            c = tmp[1];
            if(r > 0 && mat[r - 1][c] == 1){
                ret++;
                queue.add(new int[]{r - 1, c});
                mat[r-1][c] = 0;
            }
            if(c > 0 && mat[r][c-1] == 1){
                ret++;
                queue.add(new int[]{r, c - 1});
                mat[r][c-1] = 0;
            }
            if(r < row - 1 && mat[r + 1][c] == 1){
                ret++;
                queue.add(new int[]{r + 1, c});
                mat[r+1][c] = 0;
            }
            if( c < col - 1 && mat[r][c + 1] == 1){
                ret++;
                queue.add(new int[]{r, c + 1});
                mat[r][c+1] = 0;
            }
        }
        
        return ret;
        
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.mat = grid;
        this.row = grid.length;
        this.col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 1){
                    max = Math.max(dfs(i, j), max);
                }
            }
        }
        return max;
    }
}
