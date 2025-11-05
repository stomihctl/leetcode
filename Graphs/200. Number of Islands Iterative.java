class Solution {
    char[][] grid;
    int row;
    int col;

    void bfs(int r, int c){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        grid[r][c] = '0';

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int[] rcarr = queue.poll();

            r = rcarr[0];
            c = rcarr[1];

            //grid[r][c] = '0';

            for(int[] d:dirs){
                int rr = r + d[0];
                int cc = c + d[1];

                if(rr >= 0 && rr < row && cc >= 0 && cc < col && grid[rr][cc] == '1'){
                    queue.add(new int[]{rr, cc});
                    grid[rr][cc] = '0';
                }
            }
        }
    }

    public int numIslands(char[][] grid) {

        this.row = grid.length;
        this.col = grid[0].length;
        int islands = 0;

        this.grid = grid;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '1'){
                    bfs(r , c);
                    islands++;
                }
            }
        }

        return islands;
    }
}