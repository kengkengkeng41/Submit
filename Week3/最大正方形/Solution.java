package submit.Week3.最大正方形;

// https://leetcode-cn.com/problems/maximal-square/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i=0;i<m;i++) {//初始化第一列
            if (matrix[i][0]=='0') 
                dp[i][0] = 0;
            else {
                dp[i][0] = 1;
                res = 1;
            }
        }
        for (int j=0;j<n;j++) {//初始化第一行
            if (matrix[0][j]=='0') 
                dp[0][j] = 0;
            else {
                dp[0][j] = 1;
                res = 1;
            }
        }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (matrix[i][j]=='0') dp[i][j] = 0;
                else {
                    // 当前最大取决于三个分支中的最小
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1])) + 1; 
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res*res;
    }

    public static void main (String [] args) {
        Solution s = new Solution();
        char[][] matrix = { {'1','0','1','0','0'} ,
                            {'1','0','1','1','1'} ,
                            {'1','1','1','1','1'} ,
                            {'1','0','0','1','0'} };

        System.out.println(s.maximalSquare(matrix));
        return;
    }
}
