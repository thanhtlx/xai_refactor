class Problem {
    public static boolean correctBracketing(String brackets) {


        Stack<Character> stack = new Stack<>();
        for (char c : brackets.toCharArray()) {
            if (c == '<') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}