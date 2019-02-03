package javaapplication40;


public class Message {
    private int id;
    private String sender;
    private String receiver;
    private String messageData;
    private String date;
   
    public Message(){
       
    }

    public Message(int id, String sender, String receiver, String messageData, String date) {
        this.id=id;
        this.sender = sender;
        this.receiver = receiver;
        this.messageData = messageData;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessageData() {
        return messageData;
    }

    public void setMessageData(String messageData) {
        this.messageData = messageData;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
   
        @Override
    public String toString() {
        return id+ " " + sender+ " " + receiver+ " " + messageData+ " " + date;
    }  
}
