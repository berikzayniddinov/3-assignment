class NotificationHandler extends MessageHandler {
    @Override
    public void handleMessage(Message message) {
        if (message.getType().equals("notification")) {
            System.out.println("Handling notification: " + message.getContent());
        } else if (nextHandler != null) {
            nextHandler.handleMessage(message);
        }
    }
}