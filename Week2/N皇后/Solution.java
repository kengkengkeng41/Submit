package submit.Week2.N皇后;

import java.util.*;
// https://leetcode-cn.com/problems/n-queens/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> col = new HashSet<Integer>();
        Set<Integer> pie = new HashSet<Integer>();
        Set<Integer> na = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, col, pie, na);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> col, Set<Integer> pie, Set<Integer> na) {
        if (row == n) {  //终止条件
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                //冲突情况跳过
                if (col.contains(i)) 
                    continue;
                int p = row + i;  //左斜对角
                if (pie.contains(p)) 
                    continue;
                int a = row - i;  //右斜对角
                if (na.contains(a)) 
                    continue;
                //当前层处理
                queens[row] = i;
                col.add(i);
                pie.add(p);
                na.add(a);
                //深入
                backtrack(solutions, queens, n, row + 1, col, pie, na); 
                //恢复
                queens[row] = -1;
                col.remove(i);
                pie.remove(p);
                na.remove(a);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {  //解法生成
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public void printBor(List<List<String>> solutions) {  //打印输出函数
        for (int i=0;i<solutions.size();i++) {
            for (int j=0;j<solutions.get(i).size();j++) {
                System.out.print(solutions.get(i).get(j));
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        Solution s = new Solution();
        List<List<String>> solutions = s.solveNQueens(5); //测试用例5*5
        s.printBor(solutions);
        System.out.println(solutions.size());
        return;
    }
}
