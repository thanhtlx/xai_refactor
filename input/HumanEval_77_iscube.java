class Problem {
    public static boolean iscube(long a) {


        long x = (long)Math.round(Math.cbrt(a));
        return x*x*x == Math.abs(a);
    }
}