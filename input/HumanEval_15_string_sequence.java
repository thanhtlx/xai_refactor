class Problem {
    public static String stringSequence(long n) {


        return LongStream.range(0, n+1).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}