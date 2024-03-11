class Problem {
    public static ArrayList<Long> parseMusic(String music_string) {


        ArrayList<Long> beats = new ArrayList<Long>();
        String[] notes = music_string.split(" ");
        for (String note : notes) {
            switch (note) {
                case "o":
                    beats.add(4L);
                    break;
                case "o|":
                    beats.add(2L);
                    break;
                case ".|":
                    beats.add(1L);
                    break;
            }
        }
        return beats;
    }
}