package com.kangkang.store.JDK8;

/**
 * ClassName:Function
 * Package:com.kangkang.store.JDK8
 * Description:
 *
 * @date:2022/5/20 15:23
 * @author:kangkang
 */
public class Function {

}
interface Converter {
    int convert(String s);
}

 class ConverterDemo {
    public static void main(String[] args) {

        //Lambda写法
        useConverter(s -> Integer.parseInt(s));

        //引用类方法
        useConverter(Integer::parseInt);

    }

    private static void useConverter(Converter c) {
        int number = c.convert("666");
        System.out.println(number);
    }
}
