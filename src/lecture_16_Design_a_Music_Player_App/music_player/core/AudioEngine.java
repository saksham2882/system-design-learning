package lecture_16_Design_a_Music_Player_App.music_player.core;

import lecture_16_Design_a_Music_Player_App.music_player.devices.IAudioOutputDevice;
import lecture_16_Design_a_Music_Player_App.music_player.models.Song;

public class AudioEngine {

    private Song currentSong;
    private boolean IsSongPaused;

    public AudioEngine() {
        currentSong = null;
        IsSongPaused = false;
    }

    public String getCurrentSongTitle() {
        if(currentSong != null) {
            return currentSong.getTitle();
        }
        return "";
    }

    public boolean isPaused() {
        return IsSongPaused;
    }

    public void play(IAudioOutputDevice audioOutputDevice, Song song) {
        if(song == null) {
            throw new RuntimeException("Can't play null song");
        }

        // Resume if same song was paused
        if(IsSongPaused && song == currentSong) {
            IsSongPaused = false;
            System.out.println("Resuming song: " + song.getTitle());
            audioOutputDevice.playAudio(song);
            return;
        }

        currentSong = song;
        IsSongPaused = false;
        System.out.println("Playing song: " + song.getTitle());
        audioOutputDevice.playAudio(song);
    }

    public void pause() {
        if(currentSong == null) {
            throw new RuntimeException("No song is currently playing to pause.");
        }
        if(IsSongPaused) {
            throw new RuntimeException("Song is already paused.");
        }

        IsSongPaused = true;
        System.out.println("Pausing song: " + currentSong.getTitle());
    }
}
