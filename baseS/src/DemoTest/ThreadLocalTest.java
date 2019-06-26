package DemoTest;

class IMessageSend {
    public String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class Channel {
    public static IMessageSend iMessageSend;

    void setMessage(IMessageSend iMessageSend) {
        this.iMessageSend = iMessageSend;
    }

    public void sendMessage() {
        System.out.println(Thread.currentThread().getName() + " :" + iMessageSend.getMessage());
    }
}


public class ThreadLocalTest {
    public static void main(String[] args) {
        new Thread(() -> {
            Channel channel = new Channel();
            IMessageSend iMessage = new IMessageSend();
            iMessage.setMessage("A");
            channel.setMessage(iMessage);
            channel.sendMessage();
        }, "线程A").start();

        new Thread(() -> {
            Channel channel = new Channel();
            IMessageSend iMessage = new IMessageSend();
            iMessage.setMessage("B");
            channel.setMessage(iMessage);
            channel.sendMessage();
        }, "线程B").start();


        new Thread(() -> {
            IMessageSend iMessage = new IMessageSend();
            iMessage.setMessage("C");

            Channel channel = new Channel();
            channel.setMessage(iMessage);
            channel.sendMessage();
        }, "线程C").start();
    }
}
