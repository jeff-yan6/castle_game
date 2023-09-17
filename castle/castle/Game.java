package castle;

import Handler.Handler;
import Handler.HandlerBye;
import Handler.HandlerHelp;
import Handler.HandlerGo;
import Handler.HandlerTalk;
import NPC.NPC;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap<String, Handler> handlers = new HashMap<>();
        
    public Game() 
    {
        handlers.put("bye", new HandlerBye(this));
        handlers.put("help", new HandlerHelp(this));
        handlers.put("go", new HandlerGo(this));
        handlers.put("talk", new HandlerTalk(this));
        createRooms();
    }
    
    

    private void createRooms()
    {
        Room outside, castle, pub, princess, queen, forest, forest1, forest2, forest3, forest4, forest5, deep_forest;
      
        //	制造房间
        outside = new Room("城堡外", "卖花女");
        castle = new Room("大堂", "国王");
        pub = new Room("小酒吧", "酒馆老板");
        forest = new Room("森林", "猎人");
        princess = new Room("公主的房间", "公主");
        queen = new Room("皇后的房间", "皇后");
        forest1 = new Room("迷雾森林1", "");
        forest2 = new Room("迷雾森林2", "");
        forest3 = new Room("迷雾森林3", "");
        forest4 = new Room("迷雾森林4", "");
        forest5 = new Room("迷雾森林5", "");
        deep_forest = new Room("森林深处", "猎人");
        
        //	初始化房间的出口
        outside.setExits("north", castle);
        outside.setExits("south", forest);
        outside.setExits("west", forest);
        outside.setExits("east", pub);

        castle.setExits("south", outside);
        castle.setExits("west", princess);
        castle.setExits("east", queen);

        princess.setExits("east", castle);
        queen.setExits("wast", castle);

        pub.setExits("west", outside);
        pub.setExits("north", forest);
        pub.setExits("south", forest);
        pub.setExits("east", forest);

        forest.setExits("north", outside);
        forest.setExits("south", forest1);
        forest.setExits("west", forest);
        forest.setExits("east", forest);

        forest1.setExits("north", forest);
        forest1.setExits("south", forest);
        forest1.setExits("west", forest3);
        forest1.setExits("east", forest2);


        forest2.setExits("west", forest1);
        forest2.setExits("south", forest5);
        forest2.setExits("north", forest);
        forest2.setExits("east", forest);

        forest3.setExits("east", forest1);
        forest3.setExits("south", forest4);
        forest3.setExits("north", forest);
        forest3.setExits("west", forest);

        forest4.setExits("north", forest3);
        forest4.setExits("east", deep_forest);
        forest4.setExits("west", forest);
        forest4.setExits("south", forest);

        forest5.setExits("north", forest2);
        forest5.setExits("west", deep_forest);
        forest5.setExits("south", forest);
        forest5.setExits("east", forest);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showPrompt();
    }

    // 以下为用户命令

    public NPC talkNPC(){
        return currentRoom.useNPC();
    }


    public void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getExit(direction);
       

        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }
    
    public void showPrompt(){
        System.out.println("你在" + currentRoom);
        System.out.print("出口有: ");
        System.out.print(currentRoom.getExitDesc());
        System.out.println();
    }
    
    public void play() {
        Scanner in =new Scanner(System.in);
        while ( true ) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler= handlers.get(words[0]);
            String value ="";
            if(words.length > 1)
                value = words[1];
            if(handler != null) {
                handler.doCmd(value);
                if(handler.isBye())
                    break;
            }
//            if ( words[0].equals("help") ) {
//                game.printHelp();
//            } else if (words[0].equals("go") ) {
//                game.goRoom(words[1]);
//            } else if ( words[0].equals("bye") ) {
//                break;
//            }
          
    }
        in.close();
    }
	
	public static void main(String[] args) {
		Game game = new Game();
		game.printWelcome();
		game.play();
   
        System.out.println("感谢您的光临。再见！");
     
	}

}
