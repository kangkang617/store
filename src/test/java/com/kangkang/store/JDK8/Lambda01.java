package com.kangkang.store.JDK8;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * ClassName:Lambda01
 * Package:com.kangkang.store.JDK8
 * Description:
 *
 * @date:2022/5/20 14:49
 * @author:kangkang
 */
public class Lambda01 {
    public static void main(String[] args) {
        /*goShow(new UserService() {
            @Override
            public void show() {
                System.out.println("show方法调用了");
            }
        });*/

        goShow( a -> System.out.println("show方法调用了")
        );


    }

    public static void goShow(UserService service){
        service.show(4);
    }
}
