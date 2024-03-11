class Problem {
    public static String StrongestExtension(String class_name, ArrayList<String> extensions) {


        int maxStrength = Integer.MIN_VALUE;
        String strongestExtension = "";
        for (String extension : extensions) {
            int strength = 0;
            for (char c : extension.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    strength++;
                } else if (Character.isLowerCase(c)) {
                    strength--;
                }
            }
            if (strength > maxStrength) {
                maxStrength = strength;
                strongestExtension = extension;
            }
        }
        return class_name + "." + strongestExtension;
    }
}