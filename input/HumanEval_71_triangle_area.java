class Problem {
    public static float triangleArea(long a, long b, long c) {


        if (a + b > c && a + c > b && b + c > a) {
            float s = (float)(a + b + c) / 2;
            return (float)Math.sqrt(s * (s - a) * (s - b) * (s - c));
        } else {
            return -1;
        }
    }
}