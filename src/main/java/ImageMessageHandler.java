class ImageMessageHandler extends MessageHandler {
    @Override
    public void handleMessage(Message message) {
        if (message.getType().equals("image")) {
            System.out.println("Handling image message from " + message.getSender().getName());

        } else if (nextHandler != null) {
            nextHandler.handleMessage(message);
        }
    }
}