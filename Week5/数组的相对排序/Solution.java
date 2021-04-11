package submit.Week5.数组的相对排序;

import java.util.Arrays;

public class Solution {   //计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int cur:arr1)
            count[cur]++;
        int[] res = new int[arr1.length];
        int index = 0;
        for (int cur:arr2) {  //arr2中先出现的字符逐个全部添加。
            while (count[cur]>0) {
                res[index++] = cur;
                count[cur]--;
            }
        }
        for (int i=0;i<1001;i++) {  //处理未出现在arr2中的数
            while (count[i]>0) {
                res[index++] = i;
                count[i]--;
            }
        }
        return res;
    }
    public static void main (String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        Solution solu = new Solution();
        System.out.println( Arrays.toString(solu.relativeSortArray(arr1,arr2)) );
        return;
    }
}
