package lecture_16_Design_a_Music_Player_App.music_player.strategies;

import lecture_16_Design_a_Music_Player_App.music_player.models.Playlist;
import lecture_16_Design_a_Music_Player_App.music_player.models.Song;

public class SequentialPlayStrategy implements IPlayStrategy{

    private Playlist currentPlaylist;
    private int currentSongIndex;

    public SequentialPlayStrategy() {
        currentPlaylist = null;
        currentSongIndex = -1;
    }

    @Override
    public void setPlaylist(Playlist playlist) {
        currentPlaylist = playlist;
        currentSongIndex = -1;
    }

    @Override
    public Song nextSong() {
        if(currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist exists");
        }
        currentSongIndex = currentSongIndex + 1;
        return currentPlaylist.getSongList().get(currentSongIndex);
    }

    @Override
    public Song previousSong() {
        if(currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist exists");
        }
        currentSongIndex = currentSongIndex - 1;
        return currentPlaylist.getSongList().get(currentSongIndex);
    }

    @Override
    public boolean hasNextSong() {
        return ((currentSongIndex + 1) < currentPlaylist.getSize());
    }

    @Override
    public boolean hasPreviousSong() {
        return (currentSongIndex - 1 > 0);
    }
}
