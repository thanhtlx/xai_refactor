class Problem {
    public static ArrayList<Long> generateIntegers(long a, long b) {


        ArrayList<Long> result = new ArrayList<Long>();
        long start = Math.min(a, b);
        long end = Math.max(a, b);
        for (long i = start; i <= end; i++) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }
        return result;
    }
}