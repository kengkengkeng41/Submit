package submit.Week5.最长回文子串;

public class Solution3 { //中心扩散
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        int maxLen = 1, begin = 0;
        char[] cA = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            int oddLen = expandAC(cA, i, i);
            int evenLen = expandAC(cA, i, i + 1);
            int curML = Math.max(oddLen, evenLen);
            if (curML > maxLen) {
                maxLen = curML;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    private int expandAC(char[] a,int i,int j) {
        int n = a.length;
        while (i>=0 && j<n) {
            if (a[i]==a[j]) {
                i--;
                j++;
            } else
                break;
        }
        return j-i-1;
    }

    public static void main (String[] args) {
        String str = "abcccbdfe";
        Solution solu = new Solution();
        System.out.println(solu.longestPalindrome(str));
        return;
    }
}
