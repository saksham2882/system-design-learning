package lecture_16_Design_a_Music_Player_App.music_player.strategies;

import lecture_16_Design_a_Music_Player_App.music_player.models.Playlist;
import lecture_16_Design_a_Music_Player_App.music_player.models.Song;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CustomQueueStrategy implements IPlayStrategy {

    private Playlist currentPlaylist;
    private int currentSongIndex;
    private final Queue<Song> nextSongQueue;
    private final Stack<Song> previousSongQueue;


    private Song nextSequential() {
        if(currentPlaylist.getSize() == 0){
            throw  new RuntimeException("Playlist is empty");
        }
        currentSongIndex = currentSongIndex + 1;
        return currentPlaylist.getSongList().get(currentSongIndex);
    }

    private Song previousSequential() {
        if(currentPlaylist.getSize() == 0){
            throw  new RuntimeException("Playlist is empty");
        }
        currentSongIndex = currentSongIndex - 1;
        return currentPlaylist.getSongList().get(currentSongIndex);
    }

    public CustomQueueStrategy(){
        currentPlaylist = null;
        currentSongIndex = -1;
        nextSongQueue = new LinkedList<>();
        previousSongQueue = new Stack<>();
    }


    @Override
    public void setPlaylist(Playlist playlist) {
        currentPlaylist = playlist;
        currentSongIndex = -1;
        nextSongQueue.clear();
        previousSongQueue.clear();
    }

    @Override
    public Song nextSong() {
        if(currentPlaylist == null || currentPlaylist.getSize() == 0){
            throw  new RuntimeException("Playlist is empty");
        }
        if(!nextSongQueue.isEmpty()){
            Song song = nextSongQueue.poll();
            previousSongQueue.push(song);

            // update index to match queued song
            for(int i = 0; i < currentPlaylist.getSongList().size(); i++){
                if(currentPlaylist.getSongList().get(i).equals(song)){
                    currentSongIndex = i;
                    break;
                }
            }
            return song;
        }
        // Otherwise sequential
        return nextSequential();
    }

    @Override
    public Song previousSong() {
        if(currentPlaylist == null || currentPlaylist.getSize() == 0){
            throw  new RuntimeException("Playlist is empty");
        }
        if(!previousSongQueue.isEmpty()){
            Song song = previousSongQueue.pop();

            // update index to match stacked song
            for(int i = 0; i < currentPlaylist.getSongList().size(); i++){
                if(currentPlaylist.getSongList().get(i).equals(song)){
                    currentSongIndex = i;
                    break;
                }
            }
            return song;
        }
        return previousSequential();
    }

    @Override
    public boolean hasNextSong() {
        return ((currentSongIndex + 1) < currentPlaylist.getSize());
    }

    @Override
    public boolean hasPreviousSong() {
        return (currentSongIndex - 1 > 0);
    }

    @Override
    public void addToNextSong(Song nextSong) {
        if(nextSong == null) {
            throw  new RuntimeException("nextSong is null");
        }
        nextSongQueue.add(nextSong);
    }
}
