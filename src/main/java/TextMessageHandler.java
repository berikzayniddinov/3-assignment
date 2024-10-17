class TextMessageHandler extends MessageHandler {
    @Override
    public void handleMessage(Message message) {
        if (message.getType().equals("text")) {
            System.out.println("Handling text message: " + message.getContent());
        } else if (nextHandler != null) {
            nextHandler.handleMessage(message);
        }
    }
}