package Handler;

import Handler.Handler;
import castle.Game;

public class HandlerGo extends Handler {
    public HandlerGo(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
       game.goRoom(word);
    }
    
    
}
