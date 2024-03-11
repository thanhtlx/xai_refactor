class Problem {
    public static ArrayList<Long> tri(long n) {


        ArrayList<Long> result = new ArrayList<>();
        if (n < 0) {
            return result;
        }
        if (n >= 0) {
            result.add(1l);
        }
        if (n >= 1) {
            result.add(3l);
        }
        if (n >= 2) {
            result.add(2l);
        }
        if (n >= 3) {
            for (long i = 3; i <= n; i++) {
                result.add(result.get((int)i - 1) + result.get((int)i - 2) + result.get((int)i + 1));
            }
        }
        return result;
    }
}