class Problem {
    public static String circularShift(long x, long shift) {


        String str = String.valueOf(x);
        int len = str.length();
        if (shift >= len) {
            return new StringBuilder(str).reverse().toString();
        } else {
            return str.substring(len - (int) shift, len) + str.substring(0, len - (int) shift);
        }
    }
}