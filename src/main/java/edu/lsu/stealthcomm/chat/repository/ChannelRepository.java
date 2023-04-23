package edu.lsu.stealthcomm.chat.repository;

import edu.lsu.stealthcomm.chat.model.ChannelModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChannelRepository extends MongoRepository<ChannelModel, String> {
    Optional<String> findChannelIDByReceiverIDAndSenderID(String tutorID, String studentID);
}
