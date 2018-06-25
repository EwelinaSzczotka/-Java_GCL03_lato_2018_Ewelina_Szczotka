/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.util.Objects;

/**
 *
 * @author Ewelinaa
 */
public class User implements Comparable<User>{
    
    private long id;
    private String name;
    private long createdAt;
    int numberOfSentMessages;
    
    public User(){
        numberOfSentMessages = 0;
    }
    
    public User(long id, String name){
        this.id=id;
        this.name=name;
    }
    
    
    public void setId(long id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setCreated(long time){
        createdAt = time;
    }
    
    public long getId(){
        return id;
    }
    public long getCreated(){
        return createdAt;
    }
    public String getName(){
        return name;
    }
    
    public int compareTo(User u){
        return name.compareTo(u.name);
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o==null)
            return false;
        if(getClass()!= o.getClass())
            return false;
        User user = (User)o;
        return Objects.equals(name, user.name);
    }
    
    @Override
    public int hashCode(){
       return Objects.hash(name);
   }
   
    
}
