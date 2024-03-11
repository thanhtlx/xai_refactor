class Problem {
    public static String sortNumbers(String numbers) {


        String[] words = numbers.split(" ");
        String[] sortedWords = new String[words.length];
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            switch (words[i]) {
                case "zero":
                    nums[i] = 0;
                    break;
                case "one":
                    nums[i] = 1;
                    break;
                case "two":
                    nums[i] = 2;
                    break;
                case "three":
                    nums[i] = 3;
                    break;
                case "four":
                    nums[i] = 4;
                    break;
                case "five":
                    nums[i] = 5;
                    break;
                case "six":
                    nums[i] = 6;
                    break;
                case "seven":
                    nums[i] = 7;
                    break;
                case "eight":
                    nums[i] = 8;
                    break;
                case "nine":
                    nums[i] = 9;
                    break;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    sortedWords[i] = "zero";
                    break;
                case 1:
                    sortedWords[i] = "one";
                    break;
                case 2:
                    sortedWords[i] = "two";
                    break;
                case 3:
                    sortedWords[i] = "three";
                    break;
                case 4:
                    sortedWords[i] = "four";
                    break;
                case 5:
                    sortedWords[i] = "five";
                    break;
                case 6:
                    sortedWords[i] = "six";
                    break;
                case 7:
                    sortedWords[i] = "seven";
                    break;
                case 8:

    }
}