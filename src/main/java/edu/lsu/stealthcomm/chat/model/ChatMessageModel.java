package edu.lsu.stealthcomm.chat.model;

import edu.lsu.stealthcomm.chat.enums.MessageStatus;
import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@Document(collection = "Messages")
public class ChatMessageModel {
    @Id
    private String id;
    private String channelID;
    private String messageID;
    private String senderID;
    private String senderName;
    private String receiverID;
    private String receiverName;
    private String message;
    private MessageStatus messageStatus;
    private Date timestamp;
}
