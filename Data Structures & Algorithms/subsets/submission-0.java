class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        find(0,nums,new ArrayList<>(),res);
        return res;
    }
    void find(int i,int[] nums,List<Integer> temp,List<List<Integer>> res){
        //base case
        if(i==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        //not-select
        find(i+1,nums,temp,res);
        //select
        temp.add(nums[i]);
        find(i+1,nums,temp,res);
        temp.remove(temp.size()-1);
    }
}
