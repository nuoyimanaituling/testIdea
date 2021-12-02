package com.learnGeneric2;

import java.util.ArrayList;
import java.util.List;

public class learn1 {
    /*
     泛型就是定义一种模板，例如ArrayList<T>，然后在代码中为用到的类创建对应的ArrayList<类型>
     */
    /*
    向上转型
    在Java标准库中的ArrayList<T>实现了List<T>接口，它可以向上转型为List<T>：
     */

    /*

     注意无法在静态方法create()的方法参数和返回类型上使用泛型类型T
     对于静态方法，我们可以单独改写为“泛型”方法，只需要使用另一个类型即可。我们应该把它改为另一种泛型类型，例如，<K>

     Java的泛型是由编译器在编译时实行的，编译器内部永远把所有类型T视为Object处理，但是，在需要转型的时候，
     编译器会根据T的类型自动为我们实行安全地强制转型
     泛型局限
     无法判断带泛型的类型
     不能实例化T类型
     */


    /*
    public class Pair<T> {
    private T first;
    private T last;
    public Pair() {
        // Compile error:
        first = new T();
        last = new T();
    }
}
first = new T();
last = new T();
擦拭后实际上变成了：
first = new Object();
last = new Object();
这样一来，创建new Pair<String>()和创建new Pair<Integer>()就全部成了Object，显然编译器要阻止这种类型不对的代码。


要实例化T类型，我们必须借助额外的Class<T>参数：
public class Pair<T> {
    private T first;
    private T last;
    public Pair(Class<T> clazz) {
        first = clazz.newInstance();
        last = clazz.newInstance();
    }
}
     */
    public static void main(String[] args){
        List list = new ArrayList();
        list.add("Hello");
        list.add(1);
        String first = (String) list.get(0);
        Integer second = (Integer) list.get(1);
        System.out.println(second);


    }


}


