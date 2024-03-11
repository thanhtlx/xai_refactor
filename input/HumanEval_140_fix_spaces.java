class Problem {
    public static String fixSpaces(String text) {


        StringBuilder result = new StringBuilder();
        boolean prevSpace = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (prevSpace) {
                    result.append('-');
                } else {
                    result.append('_');
                }
                prevSpace = true;
            } else {
                result.append(text.charAt(i));
                prevSpace = false;
            }
        }
        return result.toString();
    }
}