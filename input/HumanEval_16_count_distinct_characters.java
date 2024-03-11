class Problem {
    public static long countDistinctCharacters(String string) {


        return string.chars().mapToObj(i -> (char) i).map(Character::toLowerCase).distinct().count();
    }
}