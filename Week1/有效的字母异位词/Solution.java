public class Solution {
    public boolean isAnagram(String s, String t) {
        int sL = s.length() , tL = t.length();
        if(sL != tL) return false;
        int[] counts = new int[26];
        for (int i=0;i<sL;i++) {
            counts[s.charAt(i)-'a']++;
            counts[t.charAt(i)-'a']--;
        }
        for (int i=0;i<26;i++) {
            if(counts[i]!=0) return false;
        }
        return true;
    }
}
