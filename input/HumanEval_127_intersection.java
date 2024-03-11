class Problem {
    public static String intersection(Pair<Long, Long> interval1, Pair<Long, Long> interval2) {


        long start = Math.max(interval1.getValue0(), interval2.getValue0());
        long end = Math.min(interval1.getValue1(), interval2.getValue1());
        if (start > end) {
            return "NO";
        }
        long length = end - start + 1;
        if (length < 2) {
            return "NO";
        }
        for (int i = 2; i * i <= length; i++) {
            if (length % i == 0) {
                return "NO";
            }
        }
        return "YES";
    }
}