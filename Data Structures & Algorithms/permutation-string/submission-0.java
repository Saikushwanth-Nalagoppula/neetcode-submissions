class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        if(m>n) return false;
        int[] need=new int[26];
        int[] window=new int[26];
        for(int i=0;i<m;i++){
            window[s1.charAt(i)-'a']++;
        }
        int r=0;
        while(r<n){
            need[s2.charAt(r)-'a']++;
            //if r exceeds window
            if(r>=m){
                need[s2.charAt(r-m)-'a']--;
            }
            //if we got window size
            if(r>=m-1&&Arrays.equals(need,window)){
                return true;
            }
            r++;
        }
return false;
    }
}
