class Solution {
    /*class Pair{
        String r;
        String c;

        Pair(String r, String c){
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o){
            if(this == 0){
                return true;
            }
            if(!(o instanceof Pair)){
                return false;
            }
            Pair pair = (Pair) o;
            return Objects.equals(r, pair.r) && Objects.equals(c, pair.c)
        }

        @Override
        public int hashCode(){
            return Objects.hash(key, value);
        }
    }*/
    //HashSetString visited;
    char[][] grid;
    int row;
    int col;

    void dfs(int r, int c){
        if(r >= 0 && c >= 0 && r < this.row && c < this.col && grid[r][c] == '1' ){
            grid[r][c] = '0';
            //System.out.println(r +   + c);
            dfs(r - 1, c);
            dfs(r, c - 1);
            dfs(r + 1, c);
            dfs(r, c + 1);            
        }
    }

    public int numIslands(char[][] grid) {

        this.row = grid.length;
        this.col = grid[0].length;
        int islands = 0;

        //this.visited = new HashSetString();
        this.grid = grid;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '1'){
                    //System.out.println(---------------------);
                    dfs(r , c);
                    islands++;
                }
            }
        }

        return islands;
    }

}
