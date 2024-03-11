class Problem {
    public static String encode(String message) {


        StringBuilder encodedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isLowerCase(c)) {
                    if (c >= 'a' && c <= 'z') {
                        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                            encodedMessage.append((char) (c + 2));
                        } else {
                            encodedMessage.append((char) (c - 32));
                        }
                    }
                } else {
                    if (c >= 'A' && c <= 'Z') {
                        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                            encodedMessage.append((char) (c + 2));
                        } else {
                            encodedMessage.append((char) (c + 32));
                        }
                    }
                }
            } else {
                encodedMessage.append(c);
            }
        }
        return encodedMessage.toString();
    }
}