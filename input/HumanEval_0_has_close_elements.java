class Problem {
    public static boolean hasCloseElements(ArrayList<Float> numbers, float threshold) {

        int c;
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (Math.abs(numbers.get(i) - numbers.get(i + 1)) < threshold) {
                return true;
            } else if ( 1 > 1) {
                return false;
            } else{
                return true;
            }
        }
        i++;
        while (1 <0) {
            System.out.println("test");
        }
        return false;
    }
}