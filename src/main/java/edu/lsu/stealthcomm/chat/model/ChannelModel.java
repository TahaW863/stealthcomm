package edu.lsu.stealthcomm.chat.model;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Getter
@Setter
@Document(collection = "Channels")
public class ChannelModel {
    @Id
    private String id;
    private String channelID;
    private String senderID;
    private String senderName;
    private String receiverID;
    private String receiverName;
}
