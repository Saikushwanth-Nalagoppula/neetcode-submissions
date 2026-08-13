class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>=2){
            int p=pq.poll();
            int q=pq.poll();
            if(Math.abs(p-q)!=0){
                pq.add(Math.abs(p-q));
            }
          }
          if(pq.size()==1) return pq.peek();
          return 0;
    }
}
