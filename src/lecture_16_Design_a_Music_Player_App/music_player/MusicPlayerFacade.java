package lecture_16_Design_a_Music_Player_App.music_player;

import lecture_16_Design_a_Music_Player_App.music_player.core.AudioEngine;
import lecture_16_Design_a_Music_Player_App.music_player.devices.IAudioOutputDevice;
import lecture_16_Design_a_Music_Player_App.music_player.enums.DeviceType;
import lecture_16_Design_a_Music_Player_App.music_player.enums.PlayStrategyType;
import lecture_16_Design_a_Music_Player_App.music_player.managers.DeviceManager;
import lecture_16_Design_a_Music_Player_App.music_player.managers.PlaylistManager;
import lecture_16_Design_a_Music_Player_App.music_player.managers.StrategyManager;
import lecture_16_Design_a_Music_Player_App.music_player.models.Playlist;
import lecture_16_Design_a_Music_Player_App.music_player.models.Song;
import lecture_16_Design_a_Music_Player_App.music_player.strategies.IPlayStrategy;


// Singleton Class
public class MusicPlayerFacade {

    private static MusicPlayerFacade instance = null;
    private final AudioEngine audioEngine;
    private Playlist loadedPlaylist;
    private IPlayStrategy playStrategy;

    private MusicPlayerFacade() {
        loadedPlaylist = null;
        playStrategy = null;
        audioEngine = new AudioEngine();
    }

    public static synchronized MusicPlayerFacade getInstance(){
        if(instance == null){
            instance = new MusicPlayerFacade();
        }
        return instance;
    }

    public void connectDevice(DeviceType deviceType){
        DeviceManager.getInstance().connectDevice(deviceType);
    }

    public void setPlayStrategy(PlayStrategyType strategyType) {
        playStrategy = StrategyManager.getInstance().getPlayStrategy(strategyType);
    }

    public void loadPlaylist(String playlistName) {
        loadedPlaylist = PlaylistManager.getInstance().getPlaylist(playlistName);
        if(playStrategy == null){
            throw new RuntimeException("playStrategy is null");
        }
        playStrategy.setPlaylist(loadedPlaylist);
    }

    public void playSong(Song song) {
        if(!DeviceManager.getInstance().hasOutputDevice()){
            throw new RuntimeException("No audio device connected!");
        }

        IAudioOutputDevice device = DeviceManager.getInstance().getCurrentOutputDevice();
        audioEngine.play(device, song);
    }

    public void pauseSong(Song song) {
        if(!audioEngine.getCurrentSongTitle().equals(song.getTitle())){
            throw new RuntimeException("Cannot pause song that is not currently playing!");
        }
        audioEngine.pause();
    }

    public void playAllTracks() {
        if(loadedPlaylist == null){
            throw new RuntimeException("No playlist loaded.");
        }

        while (playStrategy.hasNextSong()){
            Song nextSong = playStrategy.nextSong();
            IAudioOutputDevice device = DeviceManager.getInstance().getCurrentOutputDevice();
            audioEngine.play(device, nextSong);
        }

        System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
    }

    public void playNextTrac() {
        if(loadedPlaylist == null){
            throw new RuntimeException("No playlist loaded.");
        }
        if(playStrategy.hasNextSong()){
            Song nextSong = playStrategy.nextSong();
            IAudioOutputDevice device = DeviceManager.getInstance().getCurrentOutputDevice();
            audioEngine.play(device, nextSong);
        } else {
            System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
        }
    }

    public void playPreviousTrack() {
        if(loadedPlaylist == null){
            throw new RuntimeException("No playlist loaded.");
        }
        if(playStrategy.hasPreviousSong()) {
            Song previousSong = playStrategy.previousSong();
            IAudioOutputDevice device = DeviceManager.getInstance().getCurrentOutputDevice();
            audioEngine.play(device, previousSong);
        } else {
            System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
        }
    }

    public void enqueueNext(Song song) {
        playStrategy.addToNextSong(song);
    }
}
