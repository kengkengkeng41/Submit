package submit.Week2.子集;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode-cn.com/problems/subsets/

public class Solution1 {   //迭代
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int i=0;i<nums.length;i++) {
            int n = res.size();      //初进记录当前元素个数
            for (int j=0;j<n;j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

    public static void main (String [] args) {
        Solution1 s = new Solution1();
        List<List<Integer>> res = s.subsets(new int[] {1,2,3});  //测试用例
        System.out.print(res);
        return;
    }
}
