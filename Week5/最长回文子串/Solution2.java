package submit.Week5.最长回文子串;

public class Solution2 {  //暴力+剪枝
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        int maxLen = 1, begin = 0;
        char[] cA = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > maxLen && isValid(cA, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private boolean isValid(char[] a,int i,int j) {  //判断i~j是否为回文子串
        while (i<j) {
            if (a[i]!=a[j]) return false;
            i++;j--;
        }
        return true;
    }
}
