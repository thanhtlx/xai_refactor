class Problem {
    public static Pair<Optional<Long>, Optional<Long>> largestSmallestIntegers(ArrayList<Long> lst) {


        Optional<Long> largestNegative = lst.stream().filter(x -> x < 0).max(Long::compareTo);
        Optional<Long> smallestPositive = lst.stream().filter(x -> x > 0).min(Long::compareTo);
        return Pair.with(largestNegative, smallestPositive);
    }
}