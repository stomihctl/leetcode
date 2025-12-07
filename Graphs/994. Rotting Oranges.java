class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int min = 0;
        boolean noFresh = true;
        Queue<int[]> list = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    list.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    noFresh = false;
                }
            }
        }

        if(noFresh){
            return 0;
        }
        if(!noFresh && list.isEmpty()){
            return -1;
        }
        list.add(new int[]{-1, -1});
        while(list.size() != 1){
            int[] node = list.poll();
            if(node[0] == -1){
                min++;
                list.add(new int[]{-1, -1});
            }
            else{
                if(node[0] > 0 && grid[node[0] - 1][node[1]] == 1){
                    list.add(new int[]{node[0] - 1, node[1]});
                    grid[node[0] - 1][node[1]] = 2;
                }
                if(node[1] > 0 && grid[node[0]][node[1] - 1] == 1){
                    list.add(new int[]{node[0], node[1] - 1});
                    grid[node[0]][node[1] - 1] = 2;
                }
                if(node[0] < row - 1 && grid[node[0] + 1][node[1]] == 1){
                    list.add(new int[]{node[0] + 1, node[1]});
                    grid[node[0] + 1][node[1]] = 2;
                }
                if(node[1] < col - 1 && grid[node[0]][node[1] + 1] == 1){
                    list.add(new int[]{node[0], node[1] + 1});
                    grid[node[0]][node[1] + 1] = 2;
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return min;
    }
}
