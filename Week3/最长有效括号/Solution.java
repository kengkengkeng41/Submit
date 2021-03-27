package submit.Week3.最长有效括号;

// https://leetcode-cn.com/problems/longest-valid-parentheses/submissions/

public class Solution {
    public int longestValidParentheses (String s) {
        int res = 0;
        int n = s.length();
        int[] dp = new int[n];
        for (int i=1;i<n;i++) {
            if (s.charAt(i)==')') {
                if (s.charAt(i-1)=='(') 
                    dp[i] = 2 + (i>=2 ? dp[i-2] : 0); //选择表达式处理边界问题
                else if (i-dp[i-1]>0 && s.charAt(i-dp[i]-1)=='(')
                    dp[i] = 2 + dp[i-1] + ((i-dp[i-1]-2)>=0 ? dp[i-dp[i]-2] : 0);
                        //新增  内部已匹配    之前已匹配
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    public static void main (String[] args) {
        submit.Week3.解码方法.Solution s = new submit.Week3.解码方法.Solution();
        String bracket = "()()())(";  //测试用例
        System.out.println(s.numDecodings(bracket));
        return;
    }
}
