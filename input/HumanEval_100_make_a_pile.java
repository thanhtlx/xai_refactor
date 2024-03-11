class Problem {
    public static ArrayList<Long> makeAPile(long n) {


        ArrayList<Long> result = new ArrayList<Long>();
        for (long i = 0; i < n; i++) {
            if (n % 2 == 0) {
                result.add(n + 2 * i);
            } else {
                result.add(n + 2 * i);
            }
        }
        return result;
    }
}