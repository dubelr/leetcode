class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int maxTillNow = 0;
        for(int i = 0; i < nums.length; ++i){
            maxTillNow = Math.max(maxTillNow + nums[i], 0);
            maxSum = Math.max((maxTillNow == 0 ? nums[i] : maxTillNow), maxSum);
        }
        return maxSum;        
    }
            /**     0 1 2 3   4   5   6 
        maxSum  0 2 2 100 100 100 100
        maxTill 0 2 1 100 0   4   10 
        */
}