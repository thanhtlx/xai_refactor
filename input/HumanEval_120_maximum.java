class Problem {
    public static ArrayList<Long> maximum(ArrayList<Long> arr, long k) {


        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(arr);
        ArrayList<Long> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }
        Collections.sort(result);
        return result;
    }
}