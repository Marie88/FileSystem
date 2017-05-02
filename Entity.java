package filesystem;
import java.util.List;
import java.util.ArrayList;

public class Entity {
    
    private String name;
    private List<Entity> contain;
    private int permissions;
    private String owner;
    private Entity parent;
    private Entity currentDir;
    public static Entity root;
    private boolean isDir;
    private String written;
    
    public Entity(){}
    public Entity(String name, int permissions, String owner, Entity parent, boolean isDir){
        this.name = name;
        this.permissions = permissions;
        this.owner= owner;
        if(name.equals("root"))
           this.parent=this;
           else
           this.parent = parent;
        this.isDir = isDir;
        contain = new ArrayList<Entity>();
       
    }
    public Entity contains(String search){
       if(search.equals(".")) 
           return this;
       if(search.equals(".."))
           return this.getParent();
       for(Entity e: contain){
           if(e.getName().equals(search))
               return e;
       }
       return null;
    }
    
    public static int containsRec(Entity e, String search1, String search2){
       int a=1;
       for(Entity b : e.getContain()){
          a = a*containsRec(b, search1, search2); 
       }
       if(e.getName().equals(search1) && e.getName().equals(search2))
           return 0;
       return 1;
    }
    
    public String getName(){
        return name;
    }
    
    public int getPermissions(){
        return permissions;
    }
    public void setPermissions(int t){
        permissions = t;
    }
    public Entity getParent(){
        return parent;
    }
    public void setParent(Entity e){
       parent = e; 
    }
    public String getOwner(){
        return owner;
    }
    public void setOwner(String s){
        owner = s;
    }
    public boolean getIsDir(){
        return isDir;
    }
    public void add(Entity c){
        contain.add(c);
    }
    public void remove(Entity c){
        contain.remove(c);
    }
    public void written(String write){
        this.written=write;
    }
    public String getWritten(){
        return written;
    } 
    public List<Entity> getContain() {
        return contain;
    }
    
}