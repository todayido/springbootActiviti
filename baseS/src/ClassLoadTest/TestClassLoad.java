package ClassLoadTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface IMessage {
    public String send();
}


class Message implements IMessage {

    @Override
    public String send() {
        System.out.println("执行发送...");
        return "返回数据...";
    }
}

class MyProxy implements InvocationHandler {

    private Object target = null;// 保留真实业务对象

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("123");
        Object result = method.invoke(this.target, args);
        System.out.println("456");
        return result;
    }
}

public class TestClassLoad {
    public static void main(String[] args) {
        Class<?> clazz = TestClassLoad.class;
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getClassLoader().getParent());

        IMessage message = (IMessage) new MyProxy().bind(new Message());// 必须使用接口转型
        message.send();

        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
    }
}
