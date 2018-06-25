/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;


public class Main {
    
    public static void main(String[] args){
        
        ChatEngine chat = new ChatEngine();
        
        User u1 = new User(1,"Uzytkownik");
        User u2 = new User(2,"Uzytkownik2");
        try{
            chat.addUser(u1);
            chat.addUser(u2);
            chat.removeUser(1);
        }
        catch (UserAddException ex){
            System.out.println("Nie mozna utworzyc uzytkownika");
        }
        catch ( UserRemoveException ex){
            System.out.println("Nie udalo sie usunac uzytkownika");
        }
        
        int users = chat.getNumberOfUsers();
        System.out.println(users);
        
    }
    
}
