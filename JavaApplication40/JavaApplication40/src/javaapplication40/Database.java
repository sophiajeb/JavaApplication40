package javaapplication40;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {
    
    private static final String DB_URL2 = "localhost:3306";
    private static final String FULL_DB_URL = "jdbc:mysql://" + DB_URL2 + "/messenger?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWD = "root";

    
    public int createUser(String username, String password, String fname, String lname, String type) {
        String query = "INSERT INTO `messenger`.`user` (`username`,`password`, `fname`, `lname`, `type`)"
                + "VALUES ('" + username + "', '" +  password + "', '" + fname + "', '" + lname + "', '" + type + "')";
        
        try {
            Connection connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(query);

            statement.close();
            connection.close();
            
            return i;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return 0;
        }
        
    }

    public int createMessage(String sender, String receiver, String data, String date) {
        String query = "INSERT INTO `messenger`.`messages` (`sender`,`receiver`, `data`, `date`)"
                + "VALUES ('" + sender + "', '" +  receiver + "', '" + data + "', '" + date + "')";
        
        try {
            Connection connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(query);

            statement.close();
            connection.close();
            return i;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
           return 0;
        }
    }

    public User getUser(String username) {
        String query = "SELECT * FROM user WHERE username = '" + username + "'";
        try {
            Connection connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString("lname"));
                user.setType(rs.getString("type"));

                return user;
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return null;
    }
    
    public ArrayList<User> getAllUsers() {
        
        String query = "SELECT * FROM user";
        
        ArrayList<User> arraylist = new ArrayList<>();
        
        try {
            Connection connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
             


            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String type = rs.getString("type");

                 User user = new User(id,username,password, fname, lname, type);
                 arraylist.add(user);
                 
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return arraylist;
    }

    public ArrayList<Message> getMessages() {
        String query = "SELECT * FROM messages";
        
        ArrayList<Message> arraylist = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("id");
                String sender = rs.getString("sender");
                String receiver = rs.getString("receiver");
                String date = rs.getString("date");
                String data = rs.getString("data");
                
                Message message = new Message(id, sender, receiver,date, data);
                arraylist.add(message);
                


            }
            rs.close();
            statement.close();
            connection.close();
            return arraylist;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return arraylist;
    }
    


    public int updateUser(int id,String username, String password, String fname, String lname, String type){
        String query = "UPDATE user SET username='" + username + "', password='" + password + "', fname='" + fname + "', lname='" + lname
                + "', type='" + type + "' WHERE id ='" + id + "'";
        
        try {
            Connection connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(query);

            statement.close();
            connection.close();
            return i;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return 0;
    }

    public int deleteUser(int id){
        String query = "DELETE FROM `messenger`.`user` WHERE id ='" + id + "'";
        
        try {
            Connection connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(query);

            statement.close();
            connection.close();
            return i;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return 0;
    }
    
    public int updateMessage(int id, String sender, String receiver, String date, String message){
        String query = "UPDATE messages SET sender='" + sender + "', receiver='" + receiver + "', date='" + date
                + "', data='" + message + "' WHERE id ='" + id + "'";
        
        try {
            Connection connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            Statement statement = connection.createStatement();
            int i=statement.executeUpdate(query);

            statement.close();
            connection.close();
            return i;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return 0;
    }
    
    public int deleteMessage(Message message){
        String query = "DELETE FROM `messenger`.`messages` WHERE id ='" + message.getId() + "'";
        
        try {
            Connection connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            Statement statement = connection.createStatement();
            int i=statement.executeUpdate(query);

            statement.close();
            connection.close();
            return i;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return 0;
    }
}
