/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;


import java.util.*;

public class ChatEngine {
    
    private Map<Long,User> map;
    private Map<String,User> mapName;
    private Set<String> banned;
    
    public ChatEngine(){
        map= new HashMap<Long,User>();
        banned = new HashSet<String>();
        mapName = new HashMap<String,User>();
    }
    
    public void addUser(User user) throws UserAddException {
        if(banned.contains(user.getName())) throw new UserAddException();
        
        if(map.containsValue(user)) throw new UserAddException();
        map.put(user.getId(),user);
        mapName.put(user.getName(), user);
        user.setCreated(System.currentTimeMillis());
    }
    
    public void removeUser(long userId) throws UserRemoveException {
        if((map.remove(userId)) == null) throw new UserRemoveException();
        else map.remove(userId);
    }
    
    public int getNumberOfUsers(){
        return map.size();
    }
    
    public boolean hasUser(long userId){
        if(map.containsKey(userId)) return true;
        else return false;
    }
    
    public boolean hasUser (String userName){
        return map.containsValue(userName);
    }
    
    public void createBan(String userName){
        banned.add(userName);
        if(mapName.containsKey(userName)){
            mapName.remove(userName);
        }
        
    }
    
    public void removeBan(String userName){
        banned.remove(userName);
    }
    
}
