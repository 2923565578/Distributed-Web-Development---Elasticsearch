package hu.unimiskolc.dwa.chat_search;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "chats")
public class ChatMessage {
    @Id
    private String id;
    
    @Field(type = FieldType.Text)
    private String message;
    
    @Field(type = FieldType.Text)
    private String sender;
    
    @Field(type = FieldType.Keyword)
    private String roomId;
    
    @Field(type = FieldType.Text)
    private String roomName;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
    public String getRoomName() { return roomName; }
    public void setRoomName(String roomName) { this.roomName = roomName; }
}