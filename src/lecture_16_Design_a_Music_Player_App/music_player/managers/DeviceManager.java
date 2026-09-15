package lecture_16_Design_a_Music_Player_App.music_player.managers;

import lecture_16_Design_a_Music_Player_App.music_player.devices.IAudioOutputDevice;
import lecture_16_Design_a_Music_Player_App.music_player.enums.DeviceType;
import lecture_16_Design_a_Music_Player_App.music_player.factories.DeviceFactory;

// Singleton Class
public class DeviceManager {

    private static DeviceManager instance = null;
    private IAudioOutputDevice currentOutputDevice;

    public DeviceManager() {
        currentOutputDevice = null;
    }

    public static synchronized DeviceManager getInstance() {
        if (instance == null) {
            instance = new DeviceManager();
        }
        return instance;
    }

    public void connectDevice(DeviceType deviceType) {
        if (currentOutputDevice != null) {
            // garbage collector handles it, so no explicit delete.
        }

        currentOutputDevice = DeviceFactory.createAudioOutputDevice(deviceType);

        switch (deviceType) {
            case BLUETOOTH:
                System.out.println("Connected to device BLUETOOTH");
                break;
            case WIRED:
                System.out.println("Connected to device WIRED");
                break;
            case HEADPHONES:
                System.out.println("Connected to device HEADPHONES");
                break;
        }
    }

    public IAudioOutputDevice getCurrentOutputDevice() {
        if(currentOutputDevice == null) {
            throw new RuntimeException("No output device is connected");
        }
        return currentOutputDevice;
    }

    public boolean hasOutputDevice() {
        return currentOutputDevice != null;
    }
}
