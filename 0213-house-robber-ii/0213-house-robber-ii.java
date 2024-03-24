class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);

        int n = nums.length;
        return Math.max(helper(nums,0,n-2), helper(nums,1,n-1));
    }

    public int helper(int[] nums, int start, int end){
        int rob1 = 0, rob2 = 0;
        for(int i = start; i<=end; i++){
            int newRob = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    }

}