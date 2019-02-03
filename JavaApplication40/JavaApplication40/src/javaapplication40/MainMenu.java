package javaapplication40;

import java.util.ArrayList;
import java.util.Scanner;


public class MainMenu {
    
    Database db = new Database();
    UserDAO userDao = new UserDAO();
    MessageDAO messagedao =new MessageDAO();
    Scanner input = new Scanner(System.in);
    Menu menu = new Menu();
    
    
    
             private void superAdminMenu() {
		
		menu.setTitle("*** Super Admin Menu ***");
		menu.addItem(new MenuItem("Create User", this,"createUser"));
		menu.addItem(new MenuItem("Update User", this, "updateUser"));
		menu.addItem(new MenuItem("Show All Users", this, "getAllUsers"));
                menu.addItem(new MenuItem("Delete User", this,"deleteUser"));
                menu.addItem(new MenuItem("Show All Messages", this,"showMessages"));
                menu.addItem(new MenuItem("Log Out", this,"MainMenu"));
		menu.execute();
    }
         
             
                private void adminMenu() {
		
		menu.setTitle("*** Admin Menu ***");
		menu.addItem(new MenuItem("Create a Message", this,"createMessage"));
		menu.addItem(new MenuItem("Update Message", this, "updateMessage"));
                menu.addItem(new MenuItem("Show All Messages", this,"showMessages"));
                menu.addItem(new MenuItem("Delete Message", this,"deleteMessage"));
                menu.addItem(new MenuItem("Log Out", this,"MainMenu"));
		menu.execute();
    }
    
                
                       private void userMenu() {
		
		menu.setTitle("*** User Menu ***");
		menu.addItem(new MenuItem("Create a Message", this,"createMessage"));
		menu.addItem(new MenuItem("Show All Messages", this, "showMessages"));
              //menu.addItem(new MenuItem("Log Out", this,"MainMenu"));
		menu.execute();
    }
                       
    public MainMenu(){
    
        System.out.println("Log In: ");
        System.out.println("Enter Username: ");
        String username = input.next();
        String password;
        menu.db.getUser(username);
        if ( menu.db.getUser(username) == null){
            System.out.println("*** Username not exists ***");
        }else{
            if (username.equals(menu.db.getUser(username).getUsername())){
                 {
                    System.out.println("Enter Password: ");
                    password = input.next();
                    if (password.equals(menu.db.getUser(username).getPassword())){
                        System.out.println("*** Log in successful ***");
                        String type = menu.db.getUser(username).getType();
                        switch(type){
                            case "superadmin":
                                superAdminMenu();
                                break;
                            case "admin":
                                adminMenu();
                                break;
                            case "user":
                                userMenu();
                                break;
                        }
                    }
                }
            }
        }
    }
    
        
    //-----------------------------------------------------------------------------------------------------------------

         
         //--------------------------------------------------------------------------------------------------------------

         //---------------------------------------------------------------------------------------------------------------
  
         
        //-------------------------------------------------------------------------------------------------------------
         
        public void createUser() {

            System.out.println("Create User: ");
            System.out.println("Enter Username: ");
            String username = input.next();
            System.out.println("Enter Password: ");
            String password = input.next();
            System.out.println("Enter first name: ");
            String fname = input.next();
            System.out.println("Enter last name: ");
            String lname = input.next();
            System.out.println("Enter type (admin, user): ");
            String type = input.next();

            User user = new User();
            
            user.setUsername(username);
            user.setPassword(password);
            user.setFname(fname);
            user.setLname(lname);
            user.setType(type);
            
            UserDAO userDao = new UserDAO();

            userDao.createUser(user, db);
            System.out.println("*** User created ***");
    }
        //-----------------------------------------------------------------------------------------------------------
        public void updateUser() {
            
            ArrayList<User> arraylist = userDao.getAllUsers(db);

              for(User u : arraylist) {
               System.out.println(u);
              }

            System.out.println("Update User Where id= ");
            int id=input.nextInt();
            System.out.println("Enter Username: ");
            String username = input.next();
            System.out.println("Enter Password: ");
            String password = input.next();
            System.out.println("Enter first name: ");
            String fname = input.next();
            System.out.println("Enter last name: ");
            String lname = input.next();
            System.out.println("Enter type (admin, user): ");
            String type = input.next();

            User user = new User(id,username, password, fname, lname, type);

            userDao.updateUser(user, db);
            System.out.println("*** User updated ***");
    }
        //-----------------------------------------------------------------------------------------------------------
        
          public void getAllUsers() {
          
            ArrayList<User> arraylist = userDao.getAllUsers(db);
            System.out.println("*******************************************************");
            for(User u : arraylist) {
             System.out.println(u);
            }
            System.out.println("*******************************************************");

    }
         //---------------------------------------------------------------------------------------------------------------- 
           public void deleteUser() {
               
            ArrayList<User> arraylist = userDao.getAllUsers(db);
            System.out.println("*******************************************************");
            for(User u : arraylist) {
             System.out.println(u);
            }
            
            System.out.println("Enter User id: ");
            int id=input.nextInt();

             int k = db.deleteUser(id);
             if(k==1){
             System.out.println("*** User Deleted ***");
             }
             else{ System.out.println("*** User wasn't deleted ***");}
            }
           
           //---------------------------------------------------------------------------------------------------------------
           
            public void showMessages(){

                ArrayList<Message> arraylistmessage = messagedao.getAllMessages(db);

                System.out.println("*******************************************************");
                  for(Message m : arraylistmessage) {
                    System.out.println(m);
                  }
                 System.out.println("*******************************************************");
                }
            //-------------------------------------------------------------------------------------------------------------
                public void createMessage(){

                System.out.println("*** Create a Message ***");

                System.out.println("Enter Sender Username: ");
                String sender = input.next();
                System.out.println("Enter Receiver Username: ");
                String receiver = input.next();
                System.out.println("Enter Message: ");
                String messageData = input.next();
                System.out.println("date (ex.2/1/2018): ");
                String date = input.next();


                Message message = new Message();
                message.setSender(sender);
                message.setReceiver(receiver);
                message.setMessageData(messageData);
                message.setDate(date);

                messagedao.createMessage(message, db);
                
                    System.out.println("*** Message Created ***");
            }
            //---------------------------------------------------------------------------------------------------------------
            
            public void updateMessage(){
                
                System.out.println("*******************************************************");
                ArrayList<Message> arraylistmessage = messagedao.getAllMessages(db);

                  for(Message m : arraylistmessage) {
                    System.out.println(m);
                  }
                System.out.println("*******************************************************");

                System.out.println("*** Update a Message ***");

                System.out.println("Choose a Mesage id: ");
                int id = input.nextInt();
                System.out.println("Enter Sender Username: ");
                String sender = input.next();
                System.out.println("Enter Receiver Username: ");
                String receiver = input.next();
                System.out.println("Enter Message: ");
                String messageData = input.next();
                System.out.println("date (ex.2/1/2018): ");
                String date = input.next();


                Message message = new Message(id,sender,receiver,messageData,date);
                messagedao.updateMessage(message, db);
                
                System.out.println("*** Message Updated ***");
            }
            //----------------------------------------------------------------------------------------------------------------
            public void deleteMessage(){
                
                System.out.println("*******************************************************");
                ArrayList<Message> arraylistmessage = messagedao.getAllMessages(db);

                for(Message m : arraylistmessage) {
                    System.out.println(m);
                }
                System.out.println("*******************************************************");

                System.out.println("*** Delete the Message Where ID = ");
                int id = input.nextInt();

                Message message = new Message();
                message.setId(id);
                messagedao.deleteMessage(message, db);
                System.out.println("*** Message Deleted ***");
            }
            
         
        
}

