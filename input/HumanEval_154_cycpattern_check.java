class Problem {
    public static boolean cycpatternCheck(String a, String b) {


        for (int i = 0; i < b.length(); i++) {
            if (a.contains(b)) {
                return true;
            }
            b = b.charAt(b.length() - 1) + b.substring(0, b.length() - 1);
        }
        return false;
    }
}