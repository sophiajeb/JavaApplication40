
package javaapplication40;

import java.util.ArrayList;


public class MessageDAO {
    
    
    public int createMessage(Message message,Database db) {
     
      return db.createMessage(message.getSender(), message.getReceiver(), message.getMessageData(), message.getDate());
    }

    
    public ArrayList<Message> getAllMessages(Database db){
      return db.getMessages();
    }

    
    public void updateMessage(Message message, Database db){
      db.updateMessage(message.getId(), message.getSender(), message.getReceiver(), message.getMessageData(), message.getDate());
    }
    

    public int deleteMessage(Message message, Database db){
       return db.deleteMessage(message);
    }
    
}
