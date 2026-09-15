package lecture_16_Design_a_Music_Player_App.music_player;

import lecture_16_Design_a_Music_Player_App.music_player.enums.DeviceType;
import lecture_16_Design_a_Music_Player_App.music_player.enums.PlayStrategyType;
import lecture_16_Design_a_Music_Player_App.music_player.managers.PlaylistManager;
import lecture_16_Design_a_Music_Player_App.music_player.models.Song;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayerApplication {

    private static MusicPlayerApplication instance = null;
    private final List<Song> songLibrary;

    private MusicPlayerApplication(){
        songLibrary = new ArrayList<>();
    }

    public static synchronized MusicPlayerApplication getInstance(){
        if(instance == null){
            instance = new MusicPlayerApplication();
        }
        return instance;
    }

    public void createSongInLibrary(String title, String artist, String path) {
        Song song = new Song(title, artist, path);
        songLibrary.add(song);
    }

    public Song findSongByTitle(String title){
        for (Song song : songLibrary){
            if (song.getTitle().equals(title)){
                return song;
            }
        }
        return null;
    }

    public void createPlaylist(String playlistName) {
        PlaylistManager.getInstance().createPlaylist(playlistName);
    }

    public void addSongToPlaylist(String playlistName, String songTitle) {
        Song song = findSongByTitle(songTitle);
        if(song == null) {
            throw  new RuntimeException("Song not found");
        }
        PlaylistManager.getInstance().addSongToPlaylist(playlistName, song);
    }

    public void connectAudioDevice(DeviceType deviceType) {
        MusicPlayerFacade.getInstance().connectDevice(deviceType);
    }

    public void selectPlayStrategy(PlayStrategyType  playStrategyType) {
        MusicPlayerFacade.getInstance().setPlayStrategy(playStrategyType);
    }

    public void loadPlaylist(String playlistName) {
        MusicPlayerFacade.getInstance().loadPlaylist(playlistName);
    }

    public void playSingleSong(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if(song == null) {
            throw  new RuntimeException("Song not found");
        }
        MusicPlayerFacade.getInstance().playSong(song);
    }

    public void pauseCurrentSong(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if(song == null) {
            throw  new RuntimeException("Song not found");
        }
        MusicPlayerFacade.getInstance().pauseSong(song);
    }

    public void playAllTracksInPlaylist() {
        MusicPlayerFacade.getInstance().playAllTracks();
    }

    public void playPreviousTrackInPlaylist(){
        MusicPlayerFacade.getInstance().playPreviousTrack();
    }

    public void queueSongNext(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if(song == null) {
            throw  new RuntimeException("Song not found");
        }
        MusicPlayerFacade.getInstance().enqueueNext(song);
    }
}
