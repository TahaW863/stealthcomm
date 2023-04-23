package edu.lsu.stealthcomm.chat.service;


import edu.lsu.stealthcomm.chat.model.ChatMessageModel;
import edu.lsu.stealthcomm.chat.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatMessageRepository chatMessageRepository;

    public void save(ChatMessageModel message) {
        chatMessageRepository.save(message);
    }

    public Optional<List<ChatMessageModel>> findChatMessagesByChannelID(String channelID) {
        return chatMessageRepository.findChatMessagesByChannelID(channelID);
    }
}
