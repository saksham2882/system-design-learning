package lecture_16_Design_a_Music_Player_App.music_player.devices;

import lecture_16_Design_a_Music_Player_App.music_player.models.Song;

public interface IAudioOutputDevice {

    void playAudio(Song song);
}
