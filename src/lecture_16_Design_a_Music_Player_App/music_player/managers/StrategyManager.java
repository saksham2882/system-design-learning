package lecture_16_Design_a_Music_Player_App.music_player.managers;

import lecture_16_Design_a_Music_Player_App.music_player.enums.PlayStrategyType;
import lecture_16_Design_a_Music_Player_App.music_player.strategies.CustomQueueStrategy;
import lecture_16_Design_a_Music_Player_App.music_player.strategies.IPlayStrategy;
import lecture_16_Design_a_Music_Player_App.music_player.strategies.RandomPlayStrategy;
import lecture_16_Design_a_Music_Player_App.music_player.strategies.SequentialPlayStrategy;

public class StrategyManager {

    private static StrategyManager instance = null;
    private final SequentialPlayStrategy sequentialPlayStrategy;
    private final RandomPlayStrategy randomPlayStrategy;
    private final CustomQueueStrategy customQueueStrategy;

    private StrategyManager(){
        sequentialPlayStrategy = new SequentialPlayStrategy();
        randomPlayStrategy = new RandomPlayStrategy();
        customQueueStrategy = new CustomQueueStrategy();
    }

    public static synchronized StrategyManager getInstance(){
        if(instance == null){
            instance = new StrategyManager();
        }
        return instance;
    }

    public IPlayStrategy getPlayStrategy(PlayStrategyType type) {
        if(type == PlayStrategyType.SEQUENTIAL){
            return sequentialPlayStrategy;
        }
        else if(type == PlayStrategyType.RANDOM){
            return randomPlayStrategy;
        }
        else {
            return customQueueStrategy;
        }
    }
}
