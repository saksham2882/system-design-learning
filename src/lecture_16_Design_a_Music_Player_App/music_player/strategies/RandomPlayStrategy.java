package lecture_16_Design_a_Music_Player_App.music_player.strategies;

import lecture_16_Design_a_Music_Player_App.music_player.models.Playlist;
import lecture_16_Design_a_Music_Player_App.music_player.models.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class RandomPlayStrategy implements IPlayStrategy{

    private Playlist currentPlaylist;
    private List<Song> remainingSongs;
    private Stack<Song> history;
    private final Random random;

    public RandomPlayStrategy() {
        currentPlaylist = null;
        random = new Random();
    }

    @Override
    public void setPlaylist(Playlist playlist) {
        currentPlaylist = playlist;
        if(currentPlaylist == null || currentPlaylist.getSize() == 0){
            return;
        }

        remainingSongs = new ArrayList<>(currentPlaylist.getSongList());
        history = new Stack<>();
    }

    @Override
    public Song nextSong() {
        if(currentPlaylist == null || currentPlaylist.getSize() == 0){
            throw new IllegalStateException("No more songs to play");
        }
        if(remainingSongs.isEmpty()){
            throw new IllegalStateException("No more songs to play");
        }

        int index = random.nextInt(remainingSongs.size());
        Song selectedSong = remainingSongs.get(index);

        // Remove the selected song from the list.
        int lastIndex = remainingSongs.size() - 1;
        remainingSongs.set(index, remainingSongs.get(lastIndex));
        remainingSongs.remove(lastIndex);

        history.push(selectedSong);
        return selectedSong;
    }

    @Override
    public Song previousSong() {
        if(history.isEmpty()){
            throw new IllegalStateException("No more songs to play");
        }
        Song selectedSong = history.pop();
        history.push(selectedSong);
        return selectedSong;
    }

    @Override
    public boolean hasNextSong() {
        return currentPlaylist != null && !remainingSongs.isEmpty();
    }

    @Override
    public boolean hasPreviousSong() {
        return !history.isEmpty();
    }
}
