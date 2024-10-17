class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(Message message) {
        mediator.sendMessage(message, this);
    }

    public void receive(Message message) {
        System.out.println(this.name + " received message: " + message.getContent() + " from " + message.getSender().getName());
    }
}
