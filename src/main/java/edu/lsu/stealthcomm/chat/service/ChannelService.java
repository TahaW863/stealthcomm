package edu.lsu.stealthcomm.chat.service;


import edu.lsu.stealthcomm.chat.model.ChannelModel;
import edu.lsu.stealthcomm.chat.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChannelService {
    private final ChannelRepository channelRepository;
    public Optional<String> getChannelID(String tutorID, String studentID) {
        return channelRepository.findChannelIDByReceiverIDAndSenderID(tutorID, studentID).map(String::valueOf)
                .or(() -> {
                    String channelID = UUID.randomUUID().toString();
                            ChannelModel senderChannel = ChannelModel.builder()
                                    .senderID(tutorID)
                                    .receiverID(studentID)
                                    .channelID(channelID)
                                    .build();
                            ChannelModel receiverChannel = ChannelModel.builder()
                                    .senderID(studentID)
                                    .receiverID(tutorID)
                                    .channelID(channelID)
                                    .build();
                            channelRepository.save(senderChannel);
                            channelRepository.save(receiverChannel);
                            return Optional.of(channelID);
                        }
                        );
    }
}
