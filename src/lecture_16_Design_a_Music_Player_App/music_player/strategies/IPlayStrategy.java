package lecture_16_Design_a_Music_Player_App.music_player.strategies;

import lecture_16_Design_a_Music_Player_App.music_player.models.Playlist;
import lecture_16_Design_a_Music_Player_App.music_player.models.Song;

public interface IPlayStrategy {

    void setPlaylist(Playlist playlist);
    Song nextSong();
    Song previousSong();
    boolean hasNextSong();
    boolean hasPreviousSong();

    default void addToNextSong(Song nextSong) {}
}
