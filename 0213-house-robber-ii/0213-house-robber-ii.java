class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);

        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> list1 = numList.subList(0,nums.length-1);
        List<Integer> list2 = numList.subList(1,nums.length);

        return Math.max(helper(list1), helper(list2));
    }

    public int helper(List<Integer> nums){
        Integer[] arr = nums.toArray(new Integer[0]);
        
        int rob1 = 0, rob2 = 0;
        for(int i = 0; i<arr.length; i++){
            int newRob = Math.max(arr[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    }
}