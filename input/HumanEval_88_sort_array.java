class Problem {
    public static ArrayList<Long> sortArray(ArrayList<Long> array) {


        if (array.size() == 0) {
            return array;
        }
        long first = array.get(0);
        long last = array.get(array.size() - 1);
        if ((first + last) % 2 == 0) {
            return (ArrayList<Long>) array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        } else {
            return (ArrayList<Long>) array.stream().sorted().collect(Collectors.toList());
        }
    }
}