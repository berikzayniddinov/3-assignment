// Chain of Responsibility
abstract class MessageHandler {
    protected MessageHandler nextHandler;

    public void setNextHandler(MessageHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void handleMessage(Message message);
}
