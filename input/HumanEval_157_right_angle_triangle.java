class Problem {
    public static boolean rightAngleTriangle(long a, long b, long c) {


        long[] sides = {a, b, c];
        Arrays.sort(sides);
        return Math.pow(sides[0], 2) + Math.pow(sides[1], 2) == Math.pow(sides[2], 2);
    }
}