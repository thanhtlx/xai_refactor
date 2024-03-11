class Problem {
    public static long chooseNum(long x, long y) {


        if (x > y) {
            return -1;
        }
        if (x % 2 == 0) {
            if (y % 2 == 0) {
                return y;
            } else {
                return y - 1;
            }
        } else {
            if (y % 2 == 0) {
                return y - 1;
            } else {
                return y - 2;
            }
        }
    }
}