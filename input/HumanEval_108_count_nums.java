class Problem {
    public static long countNums(ArrayList<Long> arr) {


        return arr.stream().filter(n -> {
            long sum = 0;
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum > 0;
        }).count();
    }
}