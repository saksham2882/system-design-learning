package lecture_16_Design_a_Music_Player_App.music_player.models;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private final String playlistName;
    private final List<Song> songList;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.songList = new ArrayList<Song>();
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public int getSize() {
        return songList.size();
    }

    public void addSongToPlaylist(Song song) {
        if(song == null) {
            throw new RuntimeException("Cannot add null song to playlist");
        }
        songList.add(song);
    }
}
