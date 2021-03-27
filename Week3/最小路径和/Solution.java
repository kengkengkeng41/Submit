package submit.Week3.最小路径和;

// https://leetcode-cn.com/problems/minimum-path-sum/

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int[] dp = new int[n];  //dp数组存储进行到当前行每个位置的最短路径长
        dp[0] = grid[0][0];
        for (int j=1;j<n;j++)  //第一行
            dp[j] = dp[j-1]+grid[0][j];
        for (int i=1;i<m;i++) {
            dp[0] += grid[i][0];
            for (int j=1;j<n;j++)   //每个位置取决于两个分支中小的那个
                dp[j] = Math.min(dp[j-1],dp[j])+grid[i][j];
        }
        return dp[n-1];
    }

    public static void main (String [] args) {
        Solution s = new Solution();
        int[][] grid = {{1, 2, 3},
                {4, 5, 6}};
        System.out.println(s.minPathSum(grid));
        return;
    }
}
