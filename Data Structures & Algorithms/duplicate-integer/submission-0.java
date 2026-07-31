class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                int cnt=map.get(nums[i]);
                cnt++;
                map.put(nums[i],cnt);
                if(cnt>1) return true;
            }
        }
        return false;
    }
}