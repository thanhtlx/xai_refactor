class Problem {
    public static ArrayList<Long> f(long n) {


        ArrayList<Long> result = new ArrayList<Long>();
        for (long i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                result.add(factorial(i));
            } else {
                result.add(sum(i));
            }
        }
        return result;
    }
}