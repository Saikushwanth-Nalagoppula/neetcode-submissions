class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        check(0,nums,target,new ArrayList<>(),res);
        return res;
    }
    void check(int i,int[] nums,int target,List<Integer> temp,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int j=i;j<nums.length;j++){
            if(nums[j]>target){
                break;
            }
            //add
            temp.add(nums[j]);
            check(j,nums,target-nums[j],temp,res);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}
