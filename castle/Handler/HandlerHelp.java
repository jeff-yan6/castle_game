package Handler;

import Handler.Handler;
import castle.Game;

public class HandlerHelp extends Handler {
    public HandlerHelp(Game game) {
        super(game);
    }
    @Override
    public void doCmd(String word) {
        System.out.println("迷路了吗？你可以做的命令有：go bye help talk");
        System.out.println("如：\tgo east");
    }

}
