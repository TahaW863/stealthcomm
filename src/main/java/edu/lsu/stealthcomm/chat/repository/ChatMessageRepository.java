package edu.lsu.stealthcomm.chat.repository;


import edu.lsu.stealthcomm.chat.model.ChatMessageModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessageModel, String> {
    Optional<List<ChatMessageModel>> findChatMessagesByChannelID(String channelID);
}
