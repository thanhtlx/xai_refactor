class Problem {
    public static boolean belowZero(ArrayList<Long> operations) {


        long balance = 0;
        for (long op : operations) {
            balance += op;
            if (balance < 0) {
                return true;
            }
        }
        return false;
    }
}