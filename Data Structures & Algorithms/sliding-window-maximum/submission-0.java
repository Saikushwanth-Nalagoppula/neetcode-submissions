class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int[] ans=new int[n-k+1];
        int i=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int r=0;r<n;r++){
            pq.add(new int[]{nums[r],r});
            //if window size==k
            if(r-l+1==k){
                while(!pq.isEmpty()&&pq.peek()[1]<l){
                    pq.poll();
                }
                ans[i++]=pq.peek()[0];
                  //move l
            l++;
            }
            
          
        }
        return ans;
    }
}
