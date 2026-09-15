package lecture_16_Design_a_Music_Player_App.music_player.factories;

import lecture_16_Design_a_Music_Player_App.music_player.devices.BluetoothSpeakerAdapter;
import lecture_16_Design_a_Music_Player_App.music_player.devices.HeadphoneAdapter;
import lecture_16_Design_a_Music_Player_App.music_player.devices.IAudioOutputDevice;
import lecture_16_Design_a_Music_Player_App.music_player.devices.WiredSpeakerAdapter;
import lecture_16_Design_a_Music_Player_App.music_player.enums.DeviceType;
import lecture_16_Design_a_Music_Player_App.music_player.external_device.BluetoothSpeakerAPI;
import lecture_16_Design_a_Music_Player_App.music_player.external_device.HeadphoneAPI;
import lecture_16_Design_a_Music_Player_App.music_player.external_device.WiredSpeakerAPI;

public class DeviceFactory {

    public static IAudioOutputDevice createAudioOutputDevice(DeviceType deviceType) {
        return switch (deviceType) {
            case BLUETOOTH -> new BluetoothSpeakerAdapter(new BluetoothSpeakerAPI());
            case HEADPHONES -> new HeadphoneAdapter(new HeadphoneAPI());
            default -> new WiredSpeakerAdapter(new WiredSpeakerAPI());
        };
    }
}
