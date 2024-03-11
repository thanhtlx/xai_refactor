class Problem {
    public static String matchParens(ArrayList<String> lst) {


        int open = 0, close = 0;
        for (String s : lst) {
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    open++;
                } else if (c == ')') {
                    if (open > 0) {
                        open--;
                    } else {
                        close++;
                    }
                }
            }
        }
        return (open == close) ? "Yes" : "No";
    }
}