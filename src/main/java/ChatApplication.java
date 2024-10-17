import java.util.ArrayList;
import java.util.List;

public class ChatApplication {
    public static void main(String[] args) {
        MessageHandler textHandler = new TextMessageHandler();
        MessageHandler imageHandler = new ImageMessageHandler();
        MessageHandler notificationHandler = new NotificationHandler();

        textHandler.setNextHandler(imageHandler);
        imageHandler.setNextHandler(notificationHandler);

        ChatRoom chatRoom = new ChatRoom(textHandler);

        User user1 = new User("Alice", chatRoom);
        User user2 = new User("Bob", chatRoom);

        Command joinCommand1 = new JoinChatCommand(chatRoom, user1);
        Command joinCommand2 = new JoinChatCommand(chatRoom, user2);

        joinCommand1.execute();
        joinCommand2.execute();

        Message textMessage = new Message("Hello, how are you?", "text", user1);
        Command sendTextMessageCommand = new SendMessageCommand(user1, textMessage);
        sendTextMessageCommand.execute();

        byte[] imageData = new byte[]{1, 2, 3, 4};

        Message imageMessage = new Message(imageData, "image", user1);
        Command sendImageMessageCommand = new SendMessageCommand(user1, imageMessage);
        sendImageMessageCommand.execute();

        List<Message> messages = new ArrayList<>();

        messages.add(textMessage);
        messages.add(imageMessage);

        MessageIterator iterator = new ChatMessageIterator(messages);
        while (iterator.hasNext()) {
            Message msg = iterator.next();
            if (msg.getType().equals("text")) {
                System.out.println("Message history (text): " + msg.getContent());
            } else if (msg.getType().equals("image")) {
                System.out.println("Message history (image)");
            }
        }
    }
}
