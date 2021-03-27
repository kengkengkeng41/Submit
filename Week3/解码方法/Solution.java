package submit.Week3.解码方法;

// https://leetcode-cn.com/problems/decode-ways/
//若脑图无法预览可看以下网站我的题解
// https://leetcode-cn.com/problems/decode-ways/solution/nao-tu-fen-xi-dong-tai-gui-hua-by-206663-fh5k/

public class Solution {
    //能使解法方法增加的唯一途径是：既能独立解码，又能结合解码的字符的存在
    public int numDecodings(String s) {
        if (s.charAt(0)=='0') return 0;
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1;i<n;i++) {
            if (s.charAt(i)=='0') {
                if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2'){
                    if (i==1) dp[i] = 1;
                    else dp[i] = dp[i-2];
                }
                else
                    return 0;
            }
            else {
                int value = 10*(s.charAt(i-1)-'0') + (s.charAt(i)-'0');
                if (value>=11 && value<=26) {
                    if (i==1) dp[i] = dp[0] + 1;
                    else dp[i] = dp[i-1] + dp[i-2];
                }
                else dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }

    public static void main (String[] args) {
        Solution s = new Solution();
        String sample = "22615";
        System.out.println(s.numDecodings(sample));
        return;
    }
}
