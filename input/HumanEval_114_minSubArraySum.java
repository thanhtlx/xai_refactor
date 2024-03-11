class Problem {
    public static long minSubArraySum(ArrayList<Long> nums) {


        long sum = 0;
        long minSum = Long.MAX_VALUE;
        for (long num : nums) {
            sum += num;
            minSum = Math.min(minSum, sum);
            if (sum > 0) {
                sum = 0;
            }
        }
        return minSum;
    }
}