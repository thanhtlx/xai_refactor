class Problem {
    public static long doubleTheDifference(ArrayList<Float> lst) {


        return lst.stream()
            .filter(x -> x > 0 && x % 1 == 0)
            .mapToLong(x -> (long)x)
            .filter(x -> x % 2 != 0)
            .map(x -> x * x)
            .sum();
    }
}