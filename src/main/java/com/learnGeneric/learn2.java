package com.learnGeneric;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class learn2 {

    /*
    对任意的一个Object实例，只要我们获取了它的Class,就可以获取它的一切信息。
    Field getField(name)：根据字段名获取某个public的field（包括父类）
    Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
    Field[] getFields()：获取所有public的field（包括父类）
    Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
     */
    /*
    Class实例获取所有Method信息。Class类提供了以下几个方法来获取Method：
    Method getMethod(name, Class...)：获取某个public的Method（包括父类）
    Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
    Method[] getMethods()：获取所有public的Method（包括父类）
    Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）
     */
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));


        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        Method m = String.class.getMethod("substring", int.class);
        // 在s对象上调用该方法并获取结果:
        String r = (String) m.invoke(s, 3);
        // 打印调用结果:
        System.out.println(r);
    }
    class Student extends Person {
        public int getScore(String type) {
            return 99;
        }
        private int getGrade(int year) {
            return 1;
        }
    }

    class Person {
        public String getName() {
            return "Person";
        }
    }
    /*
    一个Method对象包含一个方法的所有信息：
    getName()：返回方法名称，例如："getScore"；
    getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
    getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
    getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。
     */

//    对Method实例调用invoke就相当于调用该方法，invoke的第一个参数是对象实例，即在哪个实例上调用该方法，后面的可变参数要与方法参数一致，否则将报错。
//    如果获取到的Method表示一个静态方法，调用静态方法时，由于无需指定实例对象，所以invoke方法传入的第一个参数永远为null。

}


