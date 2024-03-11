class Problem {
    public static boolean isPalindrome(String text) {


        int i = 0, j = text.length() - 1;
        while (i < j) {
            if (text.charAt(i) != text.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}