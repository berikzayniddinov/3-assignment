import java.util.ArrayList;
import java.util.List;

class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();
    private MessageHandler messageHandler;

    public ChatRoom(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @Override
    public void sendMessage(Message message, User user) {
        messageHandler.handleMessage(message);
        for (User u : users) {
            if (!u.equals(user)) {
                u.receive(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
