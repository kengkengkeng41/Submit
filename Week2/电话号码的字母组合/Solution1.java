package submit.Week2.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;
// https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

public class Solution1 {  //DFS
    // public List<String> letterCombinations(String digits) {
    //     List<String> res = new ArrayList<String>();
    //     if (digits.length()==0) return res;
    //     dfs(res,0,digits,"");
    //     return res;
    // }
    String[] map= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    // private void dfs(List<String> res,int index,String input,String s) {
    //     if (index==input.length()) {
    //         res.add(s);
    //         return;
    //     }
    //     char num = input.charAt(index);
    //     for(char c:map[num-'0'].toCharArray())
    //         dfs(res,index+1,input,s+c);          //字符串拼接效率低！
    // }

    //以下用StringBuilder构造字符串，效率提升很多！
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length()==0) return res;
        dfs(res,0,digits,new StringBuilder());
        return res;
    }
    
    private void dfs(List<String> res,int index,String input,StringBuilder sb) {
        if (index==input.length()) {
            res.add(sb.toString());
            return;
        }
        char num = input.charAt(index);
        for(char c:map[num-'0'].toCharArray()){
            dfs(res,index+1,input,sb.append(c));
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main (String [] args) {
        Solution1 s = new Solution1();
        System.out.println(s.letterCombinations("234"));
        return;
    }
}
