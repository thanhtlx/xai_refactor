class Problem {
    public static long vowelsCount(String s) {


        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == s.length() - 1 && (c == 'y' || c == 'Y')) {
                count++;
            } else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count++;
            }
        }
        return count;
    }
}