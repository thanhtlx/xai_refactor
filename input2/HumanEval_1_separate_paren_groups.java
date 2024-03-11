class Problem {
    public static ArrayList<String> separateParenGroups(String paren_string) {


        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : paren_string.toCharArray()) {
            if (c == ' ') continue;
            sb.append(c);
            if (c == '(') count++;
            if (c == ')') count--;
            if (count == 0) {
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        return result;
    }
}