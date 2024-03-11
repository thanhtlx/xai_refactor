class Problem {
    public static long countUpper(String s) {


        return IntStream.range(0, s.length())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> s.charAt(i))
                .filter(Character::isUpperCase)
                .filter(c -> "AEIOU".contains(c.toString()))
                .count();
    }
}