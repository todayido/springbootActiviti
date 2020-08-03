package ClassLoadTest.test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {
    private String classpath;

    public MyClassLoader(String classpath) {

        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte [] classDate=getDate(name);

            if(classDate==null){}

            else{
                //defineClass方法将字节码转化为类
                return defineClass(name,classDate,0,classDate.length);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return super.findClass(name);
    }
    //返回类的字节码
    private byte[] getDate(String className) throws IOException{
        InputStream in = null;
        ByteArrayOutputStream out = null;
        String path=classpath + File.separatorChar +
                className.replace('.',File.separatorChar)+".class";
        try {
            in=new FileInputStream(path);
            out=new ByteArrayOutputStream();
            byte[] buffer=new byte[2048];
            int len=0;
            while((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            return out.toByteArray();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            in.close();
            out.close();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            //自定义类加载器的加载路径
            MyClassLoader myClassLoader=new MyClassLoader("D:\\lib");
            /*
             * 需要自己手动编译为：javac Test.java
             * 将生成的class文件移动到com//test下面

               package com.test;
               public class Test {
                    public void say(){
                        System.out.println("Hello MyClassLoader");
                    }
               }
               
             **/

            //包名+类名
//            Class c = myClassLoader.loadClass("com.test.Test");

            ClassLoader systemClassLoader = MyClassLoader.getSystemClassLoader().getParent();// 此处shiyong.getParent()也可以
            System.out.println(systemClassLoader.getClass());
            Class<?> c = systemClassLoader.loadClass("com.test.Test");

            if(c!=null){
                Object obj=c.newInstance();
                Method method=c.getMethod("say", null);
                method.invoke(obj, null);
                System.out.println(c.getClassLoader().toString());
            }

            System.out.println(Thread.currentThread().getContextClassLoader().getClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
