package DemoTest;

interface IMessage extends AutoCloseable {
    public void send(String message);//消息发送
}

class MyMessage implements IMessage {

    @Override
    public void close() throws Exception {
        System.out.println("资源关闭");
    }

    @Override
    public void send(String message) {
        System.out.println(message + "消息被发送了...");
    }
}

public class AutoClosableTest {
    public static void main(String[] args) {
        try (IMessage iMessage = new MyMessage()) {// 必须try-catch才能关闭资源
            iMessage.send("通知");
        } catch (Exception e) {

        }
    }
}
