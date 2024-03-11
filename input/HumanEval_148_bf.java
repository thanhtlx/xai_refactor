class Problem {
    public static ArrayList<String> bf(String planet1, String planet2) {


        ArrayList<String> planets = new ArrayList<String>(Arrays.asList(
            "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"));
        if (!planets.contains(planet1) || !planets.contains(planet2)) {
            return new ArrayList<String>();
        }
        int index1 = planets.indexOf(planet1);
        int index2 = planets.indexOf(planet2);
        if (index1 > index2) {
            int temp = index1;
            index1 = index2;
            index2 = temp;
        }
        return new ArrayList<String>(planets.subList(index1 + 1, index2));
    }
}