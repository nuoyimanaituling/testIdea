package com.learnGeneric;

public class learn1 {

    /*
    JVM在第一次读取到一种class类型时，将其加载进内存。每加载一种class，JVM就为其创建一个Class类型的实例，并关联起来。
    注意：这里的Class类型是一个名叫Class的class
    一个Class实例包含了该class的所有完整信息：
    由于JVM为每个加载的class创建了对应的Class实例，并在实例中保存了该class的所有信息，包括类名、包名、父类、实现的接口、所有方法、字段等，
    因此，如果获取了某个Class实例，我们就可以通过这个Class实例获取到该实例对应的class的所有信息。
    这种通过Class实例获取class信息的方法称为反射（Reflection）。

     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 获取一个class的Class实例？
        // 1
        Class cls =String.class;
        // 2有一个实例变量，可以通过该实例变量提供的getClass()方法获取：
        String ss= "helo world";
        Class cls1 =ss.getClass();
        // 3 如果知道一个class的完整类名，可以通过静态方法Class.forName()获取：
        Class cls3 = Class.forName("java.lang.String");
//        因为Class实例在JVM中是唯一的，所以，上述方法获取的Class实例是同一个实例。可以用==比较两个Class实例：
        boolean same = cls==cls1;
        System.out.println(same);

        /*
        获取到了一个Class实例，我们就可以通过该Class实例来创建对应类型的实例：但是只能调用public的无参数构造方法。带参数的构造方法，
        或者非public的构造方法都无法通过Class.newInstance()被调用。
         */
        // 获取String的Class实例:
        Class cls4 = String.class;
        // 创建一个String实例:
        String s = (String) cls4.newInstance();

    }
}
