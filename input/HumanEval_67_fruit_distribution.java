class Problem {
    public static long fruitDistribution(String s, long n) {


        String[] parts = s.split(" and ");
        long apples = Long.parseLong(parts[0].split(" ")[0]);
        long oranges = Long.parseLong(parts[1].split(" ")[0]);
        return n - apples - oranges;
    }
}