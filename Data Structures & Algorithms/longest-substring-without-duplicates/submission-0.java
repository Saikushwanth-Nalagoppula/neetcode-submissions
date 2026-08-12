class Solution {
    public int lengthOfLongestSubstring(String s) {
        //using sliding window
        int n=s.length();
        if(n==0) return 0;
        int l=0;
        int r=0;
        int max_len=1;
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<n){
            char ch=s.charAt(r);
            if(!map.containsKey(ch)){
                map.put(ch,r);
            }
            else{
                while(l<=map.get(ch)){
                    l++;
                }
                map.put(ch,r);
            }
             max_len=Math.max(max_len,r-l+1);
                r++;
        }
        return max_len;
    }
}
