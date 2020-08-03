package di.test;

public class FactoryBean implements org.springframework.beans.factory.FactoryBean {

    public Object getObject() throws Exception {
        return new ColorRed();
    }

    public Class<?> getObjectType() {
        return ColorRed.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
