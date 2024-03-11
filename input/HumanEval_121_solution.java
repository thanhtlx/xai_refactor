class Problem {
    public static long solution(ArrayList<Long> lst) {


        return IntStream.range(0, lst.size())
                .filter(i -> i % 2 == 0 && lst.get(i) % 2 != 0)
                .mapToLong(i -> lst.get(i))
                .sum();
    }
}