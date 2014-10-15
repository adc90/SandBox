/* The mediator pattern as the name suggest allows you to set up a 
 * mediating class to seperate some of the behavior of the class that uses
 * that behavior. In this example the User class uses the ChatRoom class
 * to handle everything dealing with the sending of a message.  */

import java.util.Date;

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class mediator{
    public static void main(String[] args){
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}

//----------------------------------------------------
// The ChatRoom class in this example acts as a 
// mediating class between the main class and the User
// by printing out the data passed to it.
//----------------------------------------------------
class ChatRoom{
    public static void showMessage(User user, String message){
       System.out.println(new Date().toString()
            + " [" + user.getName() + "] :" + message); 
    }
}

//----------------------------------------------------
// The user class in this example uses the ChatRoom 
// class to decouple the printing behavior from the 
// User class. This way the user is simply responsible
// for holding the name and passing the message to the 
// ChatRoom.
//----------------------------------------------------
class User{
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
