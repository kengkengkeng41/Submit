package submit.Week2.岛屿数量;

// https://leetcode-cn.com/problems/number-of-islands/
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0) return 0;
        int count = 0;
        int row = grid.length , col = grid[0].length;
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if(grid[i][j]=='1') {
                    count++;
                    wipe(grid,i,j);
                }
            }
        }
        return count;
    }
    private void wipe(char[][] grid,int i,int j) {  //擦除当前'1'以及周围的'1'
        int r = grid.length , c = grid[0].length;
        if (i<0 || j<0 || i>=r || j>=c || grid[i][j]=='0') return; //终止条件
        grid[i][j] = '0';      //当前处理
        wipe(grid, i - 1, j);  //深入
        wipe(grid, i + 1, j);
        wipe(grid, i, j - 1);
        wipe(grid, i, j + 1);
    }

    public static void main (String [] args) {
        Solution s = new Solution();
        char[][] grid = new char[][]{    //测试用例有2个岛
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'0','0','0','1','0'},
                {'1','1','0','1','0'}
        };
        System.out.println(s.numIslands(grid));
        return;
    }
}
