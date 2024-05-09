class Problem {
    public static boolean hasCloseElements(ArrayList<Float> numbers, float threshold) {


        Collections.sort(numbers);
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (Math.abs(numbers.get(i) - numbers.get(i + 1)) < threshold) {
                return true;
            }
        }
        return false;
    }
}