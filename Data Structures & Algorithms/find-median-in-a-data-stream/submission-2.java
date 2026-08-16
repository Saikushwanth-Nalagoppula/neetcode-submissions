class MedianFinder {
//2 prioritQueues
//smaller half
PriorityQueue<Integer> first;
//larger half
PriorityQueue<Integer> second;
    public MedianFinder() {
        first=new PriorityQueue<>((a,b)->b-a);//maxheap
        second=new PriorityQueue<>();//minheap
    }
    
    public void addNum(int num) {
        first.add(num);
        //make sure every element in maxheap less than/== to the elements in minheap
        if(!first.isEmpty()&&!second.isEmpty()&&first.peek()>second.peek()){
            second.add(first.poll());
        }
        //balance the size
        if(second.size()>first.size()){
            first.add(second.poll());
        }
        if(first.size()>second.size()+1){
            second.add(first.poll());
        }
    }
    
    public double findMedian() {
        if (first.size()!=second.size()){
            return first.peek();
        }
        else{
            return (double)(first.peek()+second.peek())/2;
        }
    }
}
