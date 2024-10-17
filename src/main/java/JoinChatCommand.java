class JoinChatCommand implements Command {
    private ChatRoom chatRoom;
    private User user;

    public JoinChatCommand(ChatRoom chatRoom, User user) {
        this.chatRoom = chatRoom;
        this.user = user;
    }

    @Override
    public void execute() {
        chatRoom.addUser(user);
        System.out.println(user.getName() + " joined the chat.");
    }
}