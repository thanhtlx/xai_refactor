class Problem {
    public static float meanAbsoluteDeviation(ArrayList<Float> numbers) {


        float sum = 0;
        for (float num : numbers) {
            sum += num;
        }
        float mean = sum / numbers.size();
        float mad = 0;
        for (float num : numbers) {
            mad += Math.abs(num - mean);
        }
        return mad / numbers.size();
    }
}