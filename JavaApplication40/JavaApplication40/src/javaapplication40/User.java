package javaapplication40;


public class User {
    private int id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String type;

    public User(){
        
    }
    
    public User(int id, String username, String password, String fname, String lname, String type) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
        @Override
    public String toString() {
        return id+" "+ username +" "+ password+ " " + fname +" " + lname+ " "  + type;
    }    
    
}
