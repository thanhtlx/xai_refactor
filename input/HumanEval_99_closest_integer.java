class Problem {
    public static long closestInteger(String value) {


        double num = Double.parseDouble(value);
        long floor = (long) num;
        long ceil = (long) Math.ceil(num);
        if (Math.abs(num - floor) < Math.abs(num - ceil)) {
            return floor;
        } else {
            return ceil;
        }
    }
}