package Items;

import NPC.NPC;
import java.util.HashMap;

public class Item {
    private String name = new String();
    private String npc_name = new String();

    public Item(String name, String npc){
        this.name = name;
        this.npc_name = npc;
    }
    public boolean use_item(String npc){
        if( this.npc_name == npc)
            return true;
        else{
            System.out.println(name + "对" + npc_name + "使用无效");
            return false;
        }
    }
}
