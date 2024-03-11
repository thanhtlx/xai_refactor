class Problem {
    public static long canArrange(ArrayList<Long> arr) {


        long n = arr.size();
        for (long i = n - 1; i > 0; i--) {
            if (arr.get((int)i) < arr.get((int)(i - 1))) {
                return i;
            }
        }
        return -1;
    }
}