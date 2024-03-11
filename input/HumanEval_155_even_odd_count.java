class Problem {
    public static Pair<Long, Long> evenOddCount(long num) {


        long evenCount = 0;
        long oddCount = 0;
        num = Math.abs(num);
        while (num > 0) {
            if ((num % 10) % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            num = num / 10;
        }
        return Pair.with(evenCount, oddCount);
    }
}