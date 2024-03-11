class Problem {
    public static Pair<Long, Long> sumProduct(ArrayList<Long> numbers) {


        long sum = 0;
        long product = 1;
        for (long num : numbers) {
            sum += num;
            product *= num;
        }
        return Pair.with(sum, product);
    }
}