package submit.Week3.回文子串;

// https://leetcode-cn.com/problems/palindromic-substrings/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution2 {  //下标除以2分奇偶，两处理方式相同

    public List<String> countSubstrings(String s) {  //返回含有所有回文子串的字符串列表
        List<String> res = new ArrayList<>();        //其大小即为回文子串数
        int n = s.length();
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                res.add(s.substring(l,r+1));
                --l;
                ++r;
            }
        }
        return res;
    }

    public static void main (String[] args) {
        Solution2 s = new Solution2();
        List<String> res = s.countSubstrings("aaabb");  //测试用例
        System.out.println(res.size());
        for (int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
        return;
    }
}
