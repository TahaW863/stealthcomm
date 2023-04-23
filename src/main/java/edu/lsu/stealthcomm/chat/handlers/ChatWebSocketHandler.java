package edu.lsu.stealthcomm.chat.handlers;

/*@Service
public class ChatWebSocketHandler extends TextWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String chatMessage = message.getPayload();
    }
    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public ChatMessageModel handleChatMessage(ChatMessageModel message) {
        return message;
    }
}
*/