class Problem {
    public static Pair<String, Boolean> reverseDelete(String s, String c) {


        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!c.contains(String.valueOf(ch))) {
                sb.append(ch);
            }
        }
        String result = sb.toString();
        return new Pair<>(result, result.equals(result.reverse().toString()));
    }
}