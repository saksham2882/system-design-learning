package lecture_16_Design_a_Music_Player_App.music_player.managers;

import lecture_16_Design_a_Music_Player_App.music_player.models.Playlist;
import lecture_16_Design_a_Music_Player_App.music_player.models.Song;

import java.util.HashMap;
import java.util.Map;

public class PlaylistManager {

    private static PlaylistManager instance = null;
    private final Map<String, Playlist> playlists;

    public PlaylistManager() {
        playlists = new HashMap<>();
    }

    public static synchronized PlaylistManager getInstance() {
        if (instance == null) {
            instance = new PlaylistManager();
        }
        return instance;
    }

    public void createPlaylist(String playlistName) {
        if(playlists.containsKey(playlistName)) {
            throw new RuntimeException("Playlist: " + playlistName  + " already exists!");
        }
        playlists.put(playlistName, new Playlist(playlistName));
    }

    public void addSongToPlaylist(String playlistName, Song songName) {
        if(!playlists.containsKey(playlistName)) {
            throw new RuntimeException("Playlist: " + playlistName  + " doesn't exists!");
        }
        playlists.get(playlistName).addSongToPlaylist(songName);
    }

    public Playlist getPlaylist(String playlistName) {
        if(!playlists.containsKey(playlistName)) {
            throw new RuntimeException("Playlist: " + playlistName  + " doesn't exists!");
        }
        return playlists.get(playlistName);
    }
}
