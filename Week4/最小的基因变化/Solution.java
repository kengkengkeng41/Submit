package submit.Week4.最小的基因变化;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode-cn.com/problems/minimum-genetic-mutation/
class Solution {
    public int minMutation (String start,String end,String[] bank) {
        if (start.equals(end)) return 0;
        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String s:bank) bankSet.add(s);
        char[] cSet = new char[] {'A','C','G','T'};
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        int level=0;    //方法返回最小变化次数，则需记录当前基因所在层数
        while (!q.isEmpty()) {
            int n = q.size();
            while (n-->0) {
                String cur = q.poll();
                if (cur.equals(end)) return level;
                char[] curArr = cur.toCharArray();
                for(int i=0;i<curArr.length;i++) {  //尝试将当前字符串的每一个字符替换
                    char old = curArr[i];
                    for (char c:cSet) {
                        curArr[i] = c;
                        String next = new String(curArr);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);     //未访问过，且在基因库中
                            q.offer(next);
                        }
                    }
                    curArr[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
//    start: "AAAAACCC"
//    end:   "AACCCCCC"
//    bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
    public static void main (String[] args) {
        Solution solu = new Solution();
        String start = "AAAAACCC" ;
        String end = "AACCCCCC" ;
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"} ;
        System.out.println(solu.minMutation(start,end,bank));
    }
}