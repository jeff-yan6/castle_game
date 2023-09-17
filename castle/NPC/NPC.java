package NPC;

import castle.LoadFile;
import java.util.ArrayList;

public class NPC {
    private String name = new String();
    private String owe_item = new String();
    private int story_progress = 0;

    private ArrayList<String> words;
    private LoadFile file;
    public NPC(String name, String filePath){
        this.name = name;
        file = new LoadFile(filePath);
        words = file.loadFile();
    }

    public void set_exclusive_item(String item){
        this.owe_item = item;
    }

    public void be_used_item(String name){
        if(name.equals(owe_item)){
            this.story_progress = 1;
        }
    }

    public void say_something(){
        if(story_progress == 0){
            System.out.println(name+":"+"我是npc");
        } else if (story_progress == 1) {
            System.out.println(name+":"+"我是npc");
        }
    }


}
