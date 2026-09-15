package lecture_16_Design_a_Music_Player_App.music_player.devices;

import lecture_16_Design_a_Music_Player_App.music_player.external_device.WiredSpeakerAPI;
import lecture_16_Design_a_Music_Player_App.music_player.models.Song;

public class WiredSpeakerAdapter implements IAudioOutputDevice{

    private final WiredSpeakerAPI wiredSpeakerAPI;

    public WiredSpeakerAdapter(WiredSpeakerAPI wiredSpeakerAPI) {
        this.wiredSpeakerAPI = wiredSpeakerAPI;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        wiredSpeakerAPI.playAudioViaCable(payload);
    }
}
