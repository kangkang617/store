package com.kangkang.store.JDK8;

/**
 * ClassName:thread
 * Package:com.kangkang.store.JDK8
 * Description:
 *
 * @date:2022/5/20 14:34
 * @author:kangkang
 */
public class ThreadTest {

    public static void main(String[] args) {
        //匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程" + Thread.currentThread().getName() );
            }
        }).start();

        new Thread(() -> {
            System.out.println("新线程：" + Thread.currentThread().getName());
        }).start();
    }
}
