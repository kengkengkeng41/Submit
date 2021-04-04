package submit.Week4.比特位计数;

// https://leetcode-cn.com/problems/counting-bits/description/
class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);   //将最后的1置为0
            ones++;
        }
        return ones;
    }
    public static void main(String[] args) {
        Solution solu = new Solution();
        int[] res;
        res = solu.countBits(15);   //15及之前的二进制1的个数
        for (int cur : res)
            System.out.print(cur + " ");

        return;
    }
}