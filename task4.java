class task4 {
    public int maxSubarraySumCircular(int[] nums) {
        
        int totalSum = nums[0];
        
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];
        
        int minCurrent = nums[0];
        int minGlobal = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            
            totalSum += num;
           
            maxCurrent = Math.max(num, maxCurrent + num);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
            
            minCurrent = Math.min(num, minCurrent + num);
            minGlobal = Math.min(minGlobal, minCurrent);
        }
        
        if (maxGlobal < 0) return maxGlobal;
        
        return Math.max(maxGlobal, totalSum - minGlobal);
    }
}