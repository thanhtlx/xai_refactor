class Problem {
    public static long getMaxTriples(long n) {


        List<Long> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            a.add((long) (i * i - i + 1));
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((a.get(i) + a.get(j) + a.get(k)) % 3 == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}