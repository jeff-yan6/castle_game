package castle;

import NPC.NPC;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits = new HashMap<>();

    private NPC npc;
    private String filePath;

    public Room(String description, String npc_name)  {
        this.description = description;
        this.npc = new NPC(npc_name, filePath);
    }

    public void setExits(String dir, Room room) {
        exits.put(dir, room);  
    }

    @Override
    public String toString(){
        return description;
    }
    
    public String getExitDesc() {
        StringBuffer sb=new StringBuffer();
        for(String dir : exits.keySet()){
            sb.append(dir);
            sb.append(" ");
        }
        return sb.toString();
    }
    
    public Room getExit( String direction) {
       return exits.get(direction);        
    }

    public void talk_with_npc(){
        npc.say_something();
    }

    public NPC useNPC(){
        return npc;
    }
}
