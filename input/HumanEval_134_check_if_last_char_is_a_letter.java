class Problem {
    public static boolean checkIfLastCharIsALetter(String txt) {


        if (txt.length() == 0) {
            return false;
        }
        char lastChar = txt.charAt(txt.length() - 1);
        if (!Character.isLetter(lastChar)) {
            return false;
        }
        if (txt.length() == 1) {
            return true;
        }
        char secondToLastChar = txt.charAt(txt.length() - 2);
        return !Character.isLetter(secondToLastChar);
    }
}