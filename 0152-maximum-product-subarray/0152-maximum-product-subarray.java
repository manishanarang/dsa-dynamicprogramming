class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int result = nums[0];

        for(int i = 1; i<n;i++){
            result = Math.max(result, nums[i]);
        }

        int currMax=1,currMin=1;

        for(int i = 0; i<n;i++){
            if(nums[i] == 0){
                currMax=1;
                currMin=1;
            }
            else{
                int temp = currMax;
                currMax = Math.max(currMax * nums[i], Math.max(currMin*nums[i], nums[i]));
                currMin = Math.min(temp * nums[i], Math.min(currMin*nums[i], nums[i]));

                result = Math.max(result, currMax);
            }
        }
           return result; 
    }
}