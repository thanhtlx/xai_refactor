class Problem {
    public static long fizzBuzz(long n) {


        return IntStream.range(0, (int)n)
            .filter(i -> i % 11 == 0 || i % 13 == 0)
            .mapToObj(Integer::toString)
            .flatMap(s -> s.chars().mapToObj(c -> (char)c))
            .filter(c -> c == '7')
            .count();
    }
}