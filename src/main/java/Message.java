class Message {
    private String content;
    private String type;
    private User sender;
    private byte[] imageData;


    public Message(String content, String type, User sender) {
        this.content = content;
        this.type = type;
        this.sender = sender;
    }


    public Message(byte[] imageData, String type, User sender) {
        this.imageData = imageData;
        this.type = type;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public User getSender() {
        return sender;
    }

    public byte[] getImageData() {
        return imageData;
    }
}
