class Problem {
    public static ArrayList<Long> parseNestedParens(String paren_string) {


        ArrayList<Long> result = new ArrayList<Long>();
        String[] groups = paren_string.split(" ");
        for (String group : groups) {
            long maxDepth = 0;
            long currentDepth = 0;
            for (char c : group.toCharArray()) {
                if (c == '(') {
                    currentDepth++;
                    if (currentDepth > maxDepth) {
                        maxDepth = currentDepth;
                    }
                } else if (c == ')') {
                    currentDepth--;
                }
            }
            result.add(maxDepth);
        }
        return result;
    }
}