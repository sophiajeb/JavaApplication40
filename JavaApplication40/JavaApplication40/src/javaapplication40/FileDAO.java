/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication40;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class FileDAO {
    
    public FileDAO(){ 
        
        
     MessageDAO messagedao =new MessageDAO();
       Database db = new Database();
       
        ArrayList<Message> arraylistmessage = messagedao.getAllMessages(db);
        Files files=new Files();
        files.setFileName("messages_file");
          
          
            for(Message m : arraylistmessage) {
               files.logToFile(m.toString());
            }
           
           files.closeFile();
       
    }
    
}
    
