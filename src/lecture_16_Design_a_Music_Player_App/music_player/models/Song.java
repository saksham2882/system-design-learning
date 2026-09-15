package lecture_16_Design_a_Music_Player_App.music_player.models;

public class Song {

    private final String title;
    private final String artist;
    private final String filePath;

    public Song(String title, String artist, String filePath) {
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getFilePath() {
        return filePath;
    }
}
