package submit.Week5.不同的子序列;

// https://leetcode-cn.com/problems/distinct-subsequences/

public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length() , n = t.length();
        if (m<n) return 0;
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<=m;i++)
            dp[i][n] = 1;
        for (int i=m-1;i>=0;i--) {
            for (int j=n-1;j>=0;j--) {
                if (s.charAt(i) == t.charAt(j)) //若当前字符相同，则有两个选择
                                //当前匹配   或  当前不匹配
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                else
                    dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][0];
    }

    public int numDistinct2(String s, String t) {  //空间优化，滚动数组
        int sl = s.length();
        int tl = t.length();
        int[] dp = new int[tl+1];
        dp[tl] = 1;
        for (int i = sl-1; i >= 0; i--){
            for (int j = 0; j < tl; j++){
                if (t.charAt(j) == s.charAt(i)){
                    dp[j] += dp[j+1];
                }
            }
        }
        return dp[0];
    }

    public static void main (String[] args) {
        String str1 = "babgbag";
        String str2 = "bag";
        Solution s = new Solution();
        System.out.println(s.numDistinct(str1,str2));
        System.out.println(s.numDistinct2(str1,str2));
        return;
    }
}
