package com.learnGeneric2;

import java.io.File;
import java.io.IOException;

public class learn2 {
//    可以声明带泛型的数组，但不能用new操作符创建带泛型的数组：
    public static void main(String[] args){
        // 42
        System.out.println(42 == 42.0);
        try{
            File file = new File("/ssadsa");
            file.delete();
            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
