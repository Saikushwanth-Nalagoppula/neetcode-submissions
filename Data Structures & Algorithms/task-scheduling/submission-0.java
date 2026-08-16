class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;
        int m=tasks.length;
        //count the frequencies of each character...
        int[] freq=new int[26];
        int max_freq=0;
        for(int x:tasks){
            freq[x-'A']++;
            max_freq=Math.max(max_freq,freq[x-'A']);
        }
        //cal how many are having max_freq...
        int maxfreq_cnt=0;
        for(int x:freq){
            if(x==max_freq){
                maxfreq_cnt++;
            }
        }
        //minimum no. of intervals needed
        int intervals=(max_freq-1)*(n+1)+maxfreq_cnt;
        //the answer cant be lesser than the length of tasks.
        return Math.max(intervals,m);
    }
}
