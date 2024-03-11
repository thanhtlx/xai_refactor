class Problem {
    public static long digitSum(String s) {


        return s.chars()
                .filter(Character::isUpperCase)
                .mapToLong(i -> (long) i)
                .sum();
    }
}