package edu.lsu.stealthcomm.chat.controller;


import edu.lsu.stealthcomm.chat.model.ChatMessageModel;
import edu.lsu.stealthcomm.chat.service.ChannelService;
import edu.lsu.stealthcomm.chat.service.ChatService;
import edu.lsu.stealthcomm.security.service.DiffieHellmanService;
import edu.lsu.stealthcomm.security.service.KeyPairGeneratorService;
import edu.lsu.stealthcomm.user.model.UserModel;
import edu.lsu.stealthcomm.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.springframework.http.ResponseEntity;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatService chatService;
    private final ChannelService channelService;

    @MessageMapping("/chat")
    public void handleChatMessage(@Payload ChatMessageModel message) {
        try{
            log.info("User {} connected to chat with user {}", message.getSenderID(), message.getReceiverID());
            String channelID = channelService.getChannelID(message.getSenderID(), message.getReceiverID()).orElseThrow();
            message.setChannelID(channelID);
            message.setTimestamp(Date.from(Instant.now()));
            simpMessagingTemplate.convertAndSendToUser(message.getReceiverID(), "/queue/messages", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/api/v1/chat/messages/{senderId}/{recipientId}/")
    public ResponseEntity<List<ChatMessageModel>> getChatMessages (@PathVariable String senderId,
                                                                   @PathVariable String recipientId) {
        try{
            String channelID = channelService.getChannelID(senderId, recipientId).orElseThrow();
            return ResponseEntity.ok(chatService.findChatMessagesByChannelID(channelID).orElseThrow());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
