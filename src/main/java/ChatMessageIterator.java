import java.util.List;
import java.util.NoSuchElementException;

class ChatMessageIterator implements MessageIterator {
    private List<Message> messages;
    private int position = 0;

    public ChatMessageIterator(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean hasNext() {
        return position < messages.size();
    }

    @Override
    public Message next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return messages.get(position++);
    }
}
