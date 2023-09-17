package Handler;

import castle.Game;
import NPC.NPC;

public class HandlerTalk extends Handler{
    NPC talker;
    public HandlerTalk(Game game){
        super(game);
    }
    public void doCmd(String word){
        talker = game.talkNPC();
        talker.say_something();
    }
}
