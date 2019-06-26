package DemoTest;

class IMessageSend2 {
    public String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class Channel2 {
    public static ThreadLocal<IMessageSend2> local = new ThreadLocal<>();

    void setMessage(IMessageSend2 iMessageSend) {
        local.set(iMessageSend);
    }

    public void sendMessage() {
        System.out.println(Thread.currentThread().getName() + " :" + local.get().getMessage());
    }
}


public class ThreadLocalTest2 {
    public static void main(String[] args) {
        new Thread(() -> {
            Channel2 channel2 = new Channel2();
            IMessageSend2 iMessage2 = new IMessageSend2();
            iMessage2.setMessage("A");
            channel2.setMessage(iMessage2);
            channel2.sendMessage();
        }, "线程A").start();

        new Thread(() -> {
            Channel2 channel2 = new Channel2();
            IMessageSend2 iMessage2 = new IMessageSend2();
            iMessage2.setMessage("B");
            channel2.setMessage(iMessage2);
            channel2.sendMessage();
        }, "线程B").start();

        new Thread(() -> {
            Channel2 channel2 = new Channel2();
            IMessageSend2 iMessage2 = new IMessageSend2();
            iMessage2.setMessage("A");
            channel2.setMessage(iMessage2);
            channel2.sendMessage();
        }, "线程B").start();
    }
}
