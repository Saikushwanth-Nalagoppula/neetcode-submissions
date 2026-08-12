class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        Arrays.sort(nums);
        int max_len=1;
        int len=1;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                len++;
                max_len=Math.max(len,max_len);
            }
            else if(nums[i]==nums[i-1]){
                continue;
            }
            else{
                len=1;
            }
        }
    return max_len;
    }
}
