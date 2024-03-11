class Problem {
    public static String fileNameCheck(String file_name) {


        String[] validExtensions = {"txt", "exe", "dll"};
        String[] splitName = file_name.split("\\.");
        if (splitName.length != 2) {
            return "No";
        }
        String name = splitName[0];
        String extension = splitName[1];
        if (name.length() == 0 || !Character.isLetter(name.charAt(0))) {
            return "No";
        }
        if (Stream.of(validExtensions).noneMatch(extension::equals)) {
            return "No";
        }
        if (name.replaceAll("[^0-9]", "").length() > 3) {
            return "No";
        }
        return "Yes";
    }
}