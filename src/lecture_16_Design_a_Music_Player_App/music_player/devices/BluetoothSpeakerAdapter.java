package lecture_16_Design_a_Music_Player_App.music_player.devices;

import lecture_16_Design_a_Music_Player_App.music_player.external_device.BluetoothSpeakerAPI;
import lecture_16_Design_a_Music_Player_App.music_player.models.Song;

public class BluetoothSpeakerAdapter implements IAudioOutputDevice{

    private final BluetoothSpeakerAPI bluetoothSpeakerAPI;

    public BluetoothSpeakerAdapter(BluetoothSpeakerAPI bluetoothSpeakerAPI) {
        this.bluetoothSpeakerAPI = bluetoothSpeakerAPI;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " +  song.getArtist();
        bluetoothSpeakerAPI.playAudioViaBluetooth(payload);
    }
}
