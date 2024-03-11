class Problem {
    public static String stringXor(String a, String b) {


        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            result.append((a.charAt(i) - '0') ^ (b.charAt(i) - '0'));
        }
        return result.toString();
    }
}