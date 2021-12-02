package com.learnGeneric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class learn5 {
    /*
    比较Java的class和interface的区别：
    可以实例化class（非abstract）；
    不能实例化interface。
     */
    /*
    Java标准库提供了一种动态代理（Dynamic Proxy）的机制：可以在运行期动态创建某个interface的实例。
    先定义了接口，但是我们并不去编写实现类，而是直接通过JDK提供的一个Proxy.newProxyInstance()创建了一个接口对象。
    这种没有实现类但是在运行期动态创建了一个接口对象的方式，
    我们称为动态代码。JDK提供的动态创建接口对象的方式，就叫动态代理。
     */
    /*
    在运行期动态创建一个interface实例的方法如下
    1:定义一个InvocationHandler实例，它负责实现接口的方法调用
    2:通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
            使用的ClassLoader，通常就是接口类的ClassLoader；
            需要实现的接口数组，至少需要传入一个接口进去；
            用来处理接口方法调用的InvocationHandler实例。

   3:将返回的Object强制转型为接口。
     */
//  /  动态代理是通过Proxy创建代理对象，然后将接口方法“代理”给InvocationHandler完成的。

    public static void main(String[] args){
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[] { Hello.class }, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
    }

    interface Hello {
        void morning(String name);
    }

}
