class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        func(0,nums,new ArrayList<>(),res);
        return res;
    }
    void func(int i,int[] nums,List<Integer> temp,List<List<Integer>> res){
        //every node is a subset
        res.add(new ArrayList<>(temp));
        for(int j=i;j<nums.length;j++){
            if(j>i&&nums[j]==nums[j-1]){
                continue;
            }
            //next
            temp.add(nums[j]);
            func(j+1,nums,temp,res);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}
