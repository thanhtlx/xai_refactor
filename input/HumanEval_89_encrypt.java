class Problem {
    public static String encrypt(String s) {


        StringBuilder encrypted = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                encrypted.append((char) ('A' + (c - 'A' + 2 * 2) % 26));
            } else {
                encrypted.append((char) ('a' + (c - 'a' + 2 * 2) % 26));
            }
        }
        return encrypted.toString();
    }
}