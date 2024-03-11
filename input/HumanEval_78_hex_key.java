class Problem {
    public static long hexKey(String num) {


        Set<Character> primes = new HashSet<>(Arrays.asList('2', '3', '5', '7', 'B', 'D'));
        return num.chars().mapToObj(c -> (char) c).filter(primes::contains).count();
    }
}