package submit.Week5.最长回文子串;

// https://leetcode-cn.com/problems/longest-palindromic-substring/

public class Solution {  //动态规划
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n<2) return s;
        int maxLen = 1 , begin = 0;
        char[] cA = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int j=1;j<n;j++) {
            for (int i=0;i<j;i++) {
                if (cA[i]!=cA[j])
                    dp[i][j] = false;
                else {  //cA[i]==cA[j]时
                    if (j-i<3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] && j-i+1>maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    public static void main (String[] args) {
        String str = "abcccbdfe";
        Solution solu = new Solution();
        System.out.println(solu.longestPalindrome(str));
        return;
    }
}
