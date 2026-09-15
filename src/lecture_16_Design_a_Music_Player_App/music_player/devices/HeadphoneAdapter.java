package lecture_16_Design_a_Music_Player_App.music_player.devices;

import lecture_16_Design_a_Music_Player_App.music_player.external_device.HeadphoneAPI;
import lecture_16_Design_a_Music_Player_App.music_player.models.Song;

public class HeadphoneAdapter implements IAudioOutputDevice{

    private final HeadphoneAPI headphoneAPI;

    public HeadphoneAdapter(HeadphoneAPI headphoneAPI) {
        this.headphoneAPI = headphoneAPI;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        headphoneAPI.playAudioViaHeadphone(payload);
    }
}
