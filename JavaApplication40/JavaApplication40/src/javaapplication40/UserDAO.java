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
public class UserDAO {
    
    
    

    
    public int createUser(User user, Database db){
        return db.createUser(user.getUsername(), user.getPassword(),user.getFname(), user.getLname(),user.getType());
        
    }
    public ArrayList<User> getAllUsers(Database db){
        
        return db.getAllUsers();
        
    }

    public int updateUser(User user, Database db){
       return db.updateUser(user.getId(),user.getUsername(), user.getPassword(), user.getFname(), user.getLname(), user.getType());
    }

    public int deleteUser(User user, Database db){
       return db.deleteUser(user.getId());
    }   
    
    
    
    
    
}
