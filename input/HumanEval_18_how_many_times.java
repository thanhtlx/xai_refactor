class Problem {
    public static long howManyTimes(String string, String substring) {


        long count = 0;
        int idx = 0;
        while ((idx = string.indexOf(substring, idx)) != -1) {
            count++;
            idx += substring.length();
        }
        return count;
    }
}