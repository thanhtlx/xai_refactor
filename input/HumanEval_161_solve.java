class Problem {
    public static String solve(String s) {


        StringBuilder sb = new StringBuilder();
        boolean hasLetter = false;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
                if (Character.isUpperCase(c)) {
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(Character.toUpperCase(c));
                }
            } else {
                sb.append(c);
            }
        }
        if (!hasLetter) {
            return sb.reverse().toString();
        }
        return sb.toString();
    }
}