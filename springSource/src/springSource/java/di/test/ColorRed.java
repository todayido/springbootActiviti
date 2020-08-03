package di.test;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class ColorRed {

    private String colorName;
    private String colorHex;

    public ColorRed(){
        System.out.println("ColorRed constructor");
    }

    private ColorRed(Builder builder){
        colorName = builder.colorName;
        colorHex = builder.colorHex;
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    private void destroy() {
        System.out.println("destroy");
    }


    public static class Builder{
        private String colorName;
        private String colorHex;

        public Builder() {
        }

        public Builder colorName(String colorName){
            this.colorName = colorName;
            return this;
        }

        public Builder colorHex(String colorHex){
            this.colorHex = colorHex;
            return this;
        }

        public ColorRed build(){
            return new ColorRed(this);
        }
    }

}
