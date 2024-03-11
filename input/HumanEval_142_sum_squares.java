class Problem {
    public static long sumSquares(ArrayList<Long> lst) {


        return IntStream.range(0, lst.size())
            .mapToLong(i -> {
                if (i % 3 == 0) {
                    return lst.get(i) * lst.get(i) * lst.get(i);
                } else if (i % 4 == 0) {
                    return lst.get(i) * lst.get(i);
                } else {
                    return lst.get(i);
                }
            })
            .sum();
    }
}