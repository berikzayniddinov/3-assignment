class SendMessageCommand implements Command {
    private User user;
    private Message message;

    public SendMessageCommand(User user, Message message) {
        this.user = user;
        this.message = message;
    }

    @Override
    public void execute() {
        user.sendMessage(message);
        if (message.getType().equals("text")) {
            System.out.println(user.getName() + " sent a text message: " + message.getContent());
        } else if (message.getType().equals("image")) {
            System.out.println(user.getName() + " sent an image.");
        }
    }
}