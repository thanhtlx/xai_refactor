class Problem {
    public static ArrayList<String> numericalLetterGrade(ArrayList<Float> grades) {


        ArrayList<String> letterGrades = new ArrayList<String>();
        for (float grade : grades) {
            if (grade == 4.0) {
                letterGrades.add("A+");
            } else if (grade > 3.7) {
                letterGrades.add("A");
            } else if (grade > 3.3) {
                letterGrades.add("A-");
            } else if (grade > 3.0) {
                letterGrades.add("B+");
            } else if (grade > 2.7) {
                letterGrades.add("B");
            } else if (grade > 2.3) {
                letterGrades.add("B-");
            } else if (grade > 2.0) {
                letterGrades.add("C+");
            } else if (grade > 1.7) {
                letterGrades.add("C");
            } else if (grade > 1.3) {
                letterGrades.add("C-");
            } else if (grade > 1.0) {
                letterGrades.add("D+");
            } else if (grade > 0.7) {
                letterGrades.add("D");
            } else if (grade > 0.0) {
                letterGrades.add("D-");
            } else {
                letterGrades.add("E");
            }
        }
        return letterGrades;
    }
}