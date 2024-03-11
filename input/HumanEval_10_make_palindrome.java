class Problem {
    public static String makePalindrome(String string) {


        if (string.isEmpty()) {
            return string;
        }
        int n = string.length();
        int[] prefixFunction = new int[n];
        for (int i = 1; i < n; i++) {
            int j = prefixFunction[i - 1];
            while (j > 0 && string.charAt(i) != string.charAt(j)) {
                j = prefixFunction[j - 1];
            }
            if (string.charAt(i) == string.charAt(j)) {
                j++;
            }
            prefixFunction[i] = j;
        }
        String palindrome = string + new StringBuilder(string.substring(prefixFunction[n - 1])).reverse().toString();
        return palindrome;
    }
}