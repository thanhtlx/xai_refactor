class Problem {
    public static Optional<Long> nextSmallest(ArrayList<Long> lst) {


        if (lst.size() < 2) {
            return Optional.empty();
        }
        long smallest = Long.MAX_VALUE;
        long secondSmallest = Long.MAX_VALUE;
        for (long num : lst) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num > smallest && num < secondSmallest) {
                secondSmallest = num;
            }
        }
        if (secondSmallest == Long.MAX_VALUE) {
            return Optional.empty();
        }
        return Optional.of(secondSmallest);
    }
}