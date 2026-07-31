class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m) return false;
        int[] h1=new int[26];
        int[] h2=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            h1[(int)(ch-'a')]+=1;
        }
        for(int i=0;i<n;i++){
            char ch=t.charAt(i);
            h2[ch-'a']+=1;
        }
        for(int i=0;i<26;i++){
            if(h1[i]!=h2[i]) return false;
        }
        return true;
    }
}
