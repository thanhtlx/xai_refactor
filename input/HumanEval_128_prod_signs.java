class Problem {
    public static Optional<Long> prodSigns(ArrayList<Long> arr) {


        if (arr.isEmpty()) {
            return Optional.empty();
        }
        long sum = 0;
        long prod = 1;
        for (long num : arr) {
            if (num < 0) {
                prod *= -1;
            } else if (num > 0) {
                prod *= 1;
            } else {
                return Optional.of(0l);
            }
            sum += Math.abs(num);
        }
        return Optional.of(sum * prod);
    }
}