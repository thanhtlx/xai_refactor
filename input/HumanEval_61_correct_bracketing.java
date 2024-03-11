class Problem {
    public static boolean correctBracketing(String brackets) {


        Stack<Character> stack = new Stack<>();
        for (char c : brackets.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}