package FanSheTest;

interface IMessage {
    public void send();
}

class MyMessage implements IMessage {
    @Override
    public void send() {
        System.out.println("发送消息");
    }
}

class Factory {
    private Factory() {
    }

    public static IMessage getInstance(String className) {
        IMessage iMessage = null;
        try {
            iMessage = (IMessage) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iMessage;
    }
}

public class Fanshe3 {
    public static void main(String[] args) {
//        IMessage iMessage = new MyMessage();
        // 但是如果要追加一个子类，那么我们就需要修改工厂类。
        // 工厂类要解决子类与客户端的耦合问题。
        // 但是这种静态工厂开发中就不能使用。那么if判断就不能增加。
        // 怎么结局？
        // 不适用new即可，用newInstance
        IMessage iMessage = Factory.getInstance("FanSheTest.MyMessage");
        iMessage.send();
    }

}
