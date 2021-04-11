package submit.Week5.字符串转换整数atoi;

// https://leetcode-cn.com/problems/string-to-integer-atoi/

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;  //非数字非加减号，则直接返回

        long value = 0L; //防止溢出用long储存数值
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0; //遍历指针
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            value = value * 10 + (str.charAt(i++) - '0');
            if (!neg && value > Integer.MAX_VALUE) {
                value = Integer.MAX_VALUE;
                break;
            }
            if (neg && value > 1L + Integer.MAX_VALUE) {
                value = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return neg ? (int) -value : (int) value;
    }
    public static void main (String [] args) {
        Solution solu = new Solution();
        System.out.println(solu.myAtoi("  -4593"));
        return;
    }
}