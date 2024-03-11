class Problem {
    public static Optional<String> stringToMd5(String text) {


        if (text.isEmpty()) {
            return Optional.empty();
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(text.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return Optional.of(hashtext);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}