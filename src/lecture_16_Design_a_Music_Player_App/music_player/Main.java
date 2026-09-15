package lecture_16_Design_a_Music_Player_App.music_player;

import lecture_16_Design_a_Music_Player_App.music_player.enums.DeviceType;
import lecture_16_Design_a_Music_Player_App.music_player.enums.PlayStrategyType;

public class Main {
    static void main() {

        try {
            MusicPlayerApplication app = MusicPlayerApplication.getInstance();

            // Populate library
            app.createSongInLibrary("Alone", "Alan Walker", "/music/alone.mp3");
            app.createSongInLibrary("Headlight", "Alan Walker", "/music/headlight.mp3");
            app.createSongInLibrary("Darkhaast", "Arijit Singh",  "/music/darkhaast.mp3");
            app.createSongInLibrary("Stay with me", "Chanyeol",  "/music/staywithme.mp3");

            // Create playlist and add song
            app.createPlaylist("Chill Song");
            app.addSongToPlaylist("Chill Song", "Headlight");
            app.addSongToPlaylist("Chill Song", "Darkhaast");
            app.addSongToPlaylist("Chill Song", "Stay with me");

            // Connect device
            app.connectAudioDevice(DeviceType.HEADPHONES);

            // Play/Pause a single song
            app.playSingleSong("Stay with me");
            app.pauseCurrentSong("Stay with me");
            app.playSingleSong("Stay with me");     // resume


            System.out.println("\n=========== SEQUENTIAL PLAYBACK ===========\n");
            app.selectPlayStrategy(PlayStrategyType.SEQUENTIAL);
            app.loadPlaylist("Chill Song");
            app.playAllTracksInPlaylist();

            System.out.println("\n=========== RANDOM PLAYBACK ===========\n");
            app.selectPlayStrategy(PlayStrategyType.RANDOM);
            app.loadPlaylist("Chill Song");
            app.playAllTracksInPlaylist();

            System.out.println("\n=========== CUSTOM QUEUE PLAYBACK ===========\n");
            app.selectPlayStrategy(PlayStrategyType.CUSTOM_QUEUE);
            app.loadPlaylist("Chill Song");
            app.queueSongNext("Darkhaast");
            app.playAllTracksInPlaylist();

            System.out.println("\n=========== PLAY PREVIOUS IN SEQUENTIAL ===========\n");
            app.selectPlayStrategy(PlayStrategyType.SEQUENTIAL);
            app.loadPlaylist("Chill Song");
            app.playAllTracksInPlaylist();

            app.playPreviousTrackInPlaylist();
            app.playPreviousTrackInPlaylist();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
